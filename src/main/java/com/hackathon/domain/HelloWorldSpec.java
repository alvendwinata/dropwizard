package com.hackathon.domain;

public class HelloWorldSpec {
  private String message;

  public String getMessage() {
    return message;
  }

  public HelloWorldSpec setMessage(String message) {
    this.message = message;
    return this;
  }
}
