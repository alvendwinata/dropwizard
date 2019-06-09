package com.hackathon.domain;

import com.hackathon.dao.Employee;
import java.util.List;

public class HelloWorldResult {
  private String message;
  private boolean success;
  private List<Employee> employees;

  public String getMessage() {
    return message;
  }

  public HelloWorldResult setMessage(String message) {
    this.message = message;
    return this;
  }

  public boolean isSuccess() {
    return success;
  }

  public HelloWorldResult setSuccess(boolean success) {
    this.success = success;
    return this;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public HelloWorldResult setEmployees(List<Employee> employees) {
    this.employees = employees;
    return this;
  }
}
