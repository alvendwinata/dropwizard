package com.hackathon.impl;

import com.hackathon.api.EmployeeApi;
import com.hackathon.db.EmployeeAccessorInterface;
import com.hackathon.domain.Employee;
import com.hackathon.domain.UpsertEmployeeResult;
import com.hackathon.domain.UpsertEmployeeSpec;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;

public class EmployeeApiApiImpl implements EmployeeApi {
  private final EmployeeAccessorInterface employeeAccessor;

  @Inject
  public EmployeeApiApiImpl(EmployeeAccessorInterface employeeAccessor){
    this.employeeAccessor = employeeAccessor;
  }

  @Override public List<Employee> getAllEmployee() {
    List<com.hackathon.dao.Employee> employees = employeeAccessor.getAllEmployee();
    return convertToDomain(employees);
  }

  @Override public UpsertEmployeeResult upsertEmployee(UpsertEmployeeSpec spec) {
    com.hackathon.dao.Employee result = employeeAccessor.upsertEmployee(convertToDao(spec.getEmployee()));
    return new UpsertEmployeeResult().setEmployee(convertToDomain(Arrays.asList(result)).get(0)).setSuccess(true);
  }

  public List<Employee> convertToDomain(List<com.hackathon.dao.Employee> employees){
    return employees.stream().map(s -> new Employee()
    .setId(s.getId())
    .setFirstName(s.getFirstName())
    .setLastName(s.getLastName())
    .setEmail(s.getEmail())
    .setPhone(s.getPhone())
    .setPosition(s.getPosition())).collect(Collectors.toList());
  }

  public com.hackathon.dao.Employee convertToDao(Employee employee){
    return new com.hackathon.dao.Employee()
        .setId(employee.getId())
        .setFirstName(employee.getFirstName())
        .setLastName(employee.getLastName())
        .setPhone(employee.getPhone())
        .setPosition(employee.getPosition())
        .setEmail(employee.getEmail());
  }
}
