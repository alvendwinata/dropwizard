package com.hackathon.domain;

import com.hackathon.api.HelloWorldApi;

public class HelloWorldApiApiImpl implements HelloWorldApi {
  @Override public HelloWorldResult getResult(HelloWorldSpec spec) {
    try {
      return new HelloWorldResult().setMessage(spec.getMessage()).setSuccess(true);
    }catch (Exception e){
      e.printStackTrace();
      return new HelloWorldResult().setMessage("Failed !!, Unknown error occured.").setSuccess(false);
    }
  }
}
