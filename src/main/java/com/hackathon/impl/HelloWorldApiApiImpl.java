package com.hackathon.impl;

import com.hackathon.api.HelloWorldApi;
import com.hackathon.domain.HelloWorldResult;
import com.hackathon.domain.HelloWorldSpec;

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
