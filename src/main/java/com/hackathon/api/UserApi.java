package com.hackathon.api;

import com.hackathon.domain.GetAllUserResult;
import com.hackathon.domain.UpsertUserResult;
import com.hackathon.domain.UpsertUserSpec;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
public interface UserApi {

  @Path("/get/all")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  GetAllUserResult getAllUser();

  @Path("/upsert")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  UpsertUserResult upsertUser(UpsertUserSpec spec);

}
