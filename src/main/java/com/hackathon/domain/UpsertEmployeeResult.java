package com.hackathon.domain;

public class UpsertEmployeeResult {
  private boolean success;
  private Employee employee;

  public boolean isSuccess() {
    return success;
  }

  public UpsertEmployeeResult setSuccess(boolean success) {
    this.success = success;
    return this;
  }

  public Employee getEmployee() {
    return employee;
  }

  public UpsertEmployeeResult setEmployee(Employee employee) {
    this.employee = employee;
    return this;
  }
}
