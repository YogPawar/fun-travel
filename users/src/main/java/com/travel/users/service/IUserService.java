package com.travel.users.service;

import com.travel.users.jpa.entity.UserEntity;
import com.travel.users.model.User;
import java.util.List;

public interface IUserService {

  public User createUser(UserEntity user);

  public User updateUser(UserEntity user);

  public List<UserEntity> getAllUsers();

  public User getUserById(Long userId);

  public void deleteUser(Long userId);

}
