package com.hackathon.domain;

import com.hackathon.api.HelloWorld;
import com.hackathon.dao.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HelloWorldServiceImpl implements HelloWorld {
  @Override public HelloWorldResult getResult(HelloWorldSpec spec) {
    try {
      List<Employee> employees = new ArrayList<>();
      String url = "jdbc:postgresql://localhost:5432/hackathon";
      Connection conn;
      String SQL_SELECT = "Select * from employees";
      {
        try {
          conn = DriverManager.getConnection(url, "postgres", "postgres");
          PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
          ResultSet resultSet = preparedStatement.executeQuery();

          while (resultSet.next()) {

            long id = resultSet.getLong("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String position = resultSet.getString("e_position");
            String email = resultSet.getString("e_mail");
            String phone = resultSet.getString("phone");


            Employee obj = new Employee();
            obj.setId(id);
            obj.setFirstName(firstName);
            obj.setLastName(lastName);
            obj.setPosition(position);
            obj.setEmail(email);
            obj.setPhone(phone);
            employees.add(obj);

          }
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }

      return new HelloWorldResult().setMessage(spec.getMessage()).setSuccess(true).setEmployees(employees);
    }catch (Exception e){
      e.printStackTrace();
      return new HelloWorldResult().setMessage("Failed !!, Unknown error occured.").setSuccess(false);
    }
  }
}
