package com.hackathon.api;

import com.hackathon.domain.Employee;
import com.hackathon.domain.UpsertEmployeeResult;
import com.hackathon.domain.UpsertEmployeeSpec;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/employee")
public interface EmployeeApi {

  @Path("/all")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  List<Employee> getAllEmployee();

  @Path("/upsert")
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  UpsertEmployeeResult upsertEmployee(UpsertEmployeeSpec spec);
}
