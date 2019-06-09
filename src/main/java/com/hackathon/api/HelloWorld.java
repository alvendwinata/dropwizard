package com.hackathon.api;

import com.hackathon.domain.HelloWorldResult;
import com.hackathon.domain.HelloWorldSpec;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public interface HelloWorld {

  @Path("/world")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  HelloWorldResult getResult(HelloWorldSpec spec);
}
