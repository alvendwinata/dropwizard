package com.hackathon.domain;

public class LoginUserResult {
  private User user;
  private boolean success;
  private String message;

  public boolean isSuccess() {
    return success;
  }

  public LoginUserResult setSuccess(boolean success) {
    this.success = success;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public LoginUserResult setMessage(String message) {
    this.message = message;
    return this;
  }

  public User getUser() {
    return user;
  }

  public LoginUserResult setUser(User user) {
    this.user = user;
    return this;
  }
}
