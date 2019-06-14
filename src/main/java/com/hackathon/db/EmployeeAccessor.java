package com.hackathon.db;

import com.hackathon.dao.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAccessor implements EmployeeAccessorInterface {

  private final String url = "jdbc:postgresql://localhost:5432/hackathon";
  private Connection conn;

  @Override public List<Employee> getAllEmployee() {
    List<Employee> employees = new ArrayList<>();
      try {
        String SQL_SELECT = "Select * from employees";
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
      } finally {
        return employees;
      }
  }

  @Override public Employee upsertEmployee(Employee employee) {
    Employee result = new Employee();
    try{
      String SQL_UPSERT;
      if(employee.getId() == null){
        SQL_UPSERT = "INSERT INTO employees(first_name, last_name, e_position, phone, e_mail) VALUES ('"
        + employee.getFirstName() + "', '" + employee.getLastName() + "', '" + employee.getPosition() + "', '" + employee.getPhone() + "', '" + employee.getEmail() + "') RETURNING id";

        conn = DriverManager.getConnection(url, "postgres", "postgres");
        PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPSERT);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        long id = resultSet.getLong("id");
        result.setId(id);
        result.setFirstName(employee.getFirstName());
        result.setLastName(employee.getLastName());
        result.setPosition(employee.getPosition());
        result.setEmail(employee.getEmail());
        result.setPhone(employee.getPhone());

        return result;
      } else {
        //do update
      }

      conn.close();
    }catch (Exception e){
      e.printStackTrace();
    } finally {
      return result;
    }
  }
}
