package com.hackathon.domain;

public class UpsertUserResult {
  private boolean success;
  private User user;

  public boolean isSuccess() {
    return success;
  }

  public UpsertUserResult setSuccess(boolean success) {
    this.success = success;
    return this;
  }

  public User getUser() {
    return user;
  }

  public UpsertUserResult setUser(User user) {
    this.user = user;
    return this;
  }
}
