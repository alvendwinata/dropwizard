package com.hackathon.domain;

public class UpsertUserSpec {
  User user;

  public User getUser() {
    return user;
  }

  public UpsertUserSpec setUser(User user) {
    this.user = user;
    return this;
  }
}
