package com.hackathon.domain;

public class HelloWorldResult {
  private String message;
  private boolean success;

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
}
