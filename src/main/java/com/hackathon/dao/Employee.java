package com.hackathon.dao;

public class Employee {
  private long id;
  private String firstName;
  private String lastName;
  private String position;
  private String phone;
  private String email;

  public long getId() {
    return id;
  }

  public Employee setId(long id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public Employee setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public Employee setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getPosition() {
    return position;
  }

  public Employee setPosition(String position) {
    this.position = position;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public Employee setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Employee setEmail(String email) {
    this.email = email;
    return this;
  }
}
