package com.hackathon.domain;

public class UpsertEmployeeSpec {
  Employee employee;

  public Employee getEmployee() {
    return employee;
  }

  public UpsertEmployeeSpec setEmployee(Employee employee) {
    this.employee = employee;
    return this;
  }
}
