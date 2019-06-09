package com.hackathon.db;

import com.hackathon.dao.Employee;
import java.util.List;

public interface EmployeeAccessorInterface {
  List<Employee> getAllEmployee();

  Employee upsertEmployee(Employee employee);
}
