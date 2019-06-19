package com.hackathon.impl;

import com.hackathon.api.UserApi;
import com.hackathon.db.UserAccessor;
import com.hackathon.domain.GetAllUserResult;
import com.hackathon.domain.LoginUserResult;
import com.hackathon.domain.LoginUserSpec;
import com.hackathon.domain.UpsertUserResult;
import com.hackathon.domain.UpsertUserSpec;
import com.hackathon.domain.User;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;

public class UserApiImpl implements UserApi {
  private final UserAccessor userAccessor;

  @Inject
  public UserApiImpl(UserAccessor userAccessor){
    this.userAccessor = userAccessor;
  }

  @Override public GetAllUserResult getAllUser() {
    try {
      List<com.hackathon.dao.User> users = userAccessor.getAllUser();
      return new GetAllUserResult().setSuccess(true).setUser(convertToDomain(users));
    } catch (Exception e){
      e.printStackTrace();
      return new GetAllUserResult().setSuccess(false);
    }
  }

  @Override public UpsertUserResult upsertUser(UpsertUserSpec spec) {
    try {
      com.hackathon.dao.User user = userAccessor.upsertUser(convertToDao(spec.getUser()));
      return new UpsertUserResult().setSuccess(true).setUser(convertToDomain(Arrays.asList(user)).get(0));
    } catch (Exception e){
      e.printStackTrace();
      return new UpsertUserResult().setSuccess(false);
    }
  }

  @Override public LoginUserResult login(LoginUserSpec spec) {
    List<com.hackathon.dao.User> users = userAccessor.getAllUser();
    Map<String, com.hackathon.dao.User> userByEmail = users.stream().collect(Collectors.toMap(s -> s.getEmail(), s -> s));
    if(userByEmail.get(spec.getEmail()).getPassword().equals(spec.getPassword())){
      return new LoginUserResult().setMessage("Login Success")
          .setSuccess(true)
          .setUser(convertToDomain(
              Arrays.asList(userByEmail.get(spec.getEmail())
              )
          ).get(0));
    } else {
      return null;
    }

  }

  public List<User> convertToDomain(List<com.hackathon.dao.User> users){
    if(users == null) return Collections.emptyList();
    return users.stream().map(s -> new User()
      .setId(s.getId())
      .setName(s.getName())
      .setEmail(s.getEmail())
      .setPassword(s.getPassword())
      .setPhone(s.getPhone())
      .setRole(s.getRole())).collect(Collectors.toList());
  }

  public com.hackathon.dao.User convertToDao(User user){
    return new com.hackathon.dao.User()
        .setId(user.getId())
        .setName(user.getName())
        .setEmail(user.getEmail())
        .setPassword(user.getPassword())
        .setPhone(user.getPhone())
        .setRole(user.getRole());
  }
}
