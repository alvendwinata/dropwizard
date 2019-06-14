package com.hackathon.db;

import com.hackathon.dao.User;
import java.util.List;

public interface UserAccessorInterface {
  List<User> getAllUser();

  User upsertUser(User user);
}
