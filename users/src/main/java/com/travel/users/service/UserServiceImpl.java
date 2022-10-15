package com.travel.users.service;

import com.travel.users.exception.UserException;
import com.travel.users.jpa.entity.UserEntity;
import com.travel.users.jpa.repository.UserRepository;
import com.travel.users.model.User;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

  @Autowired
  ConversionService conversionServices;

  @Autowired
  UserRepository userRepository;

  @Override
  public User createUser(UserEntity user) {
    return conversionServices.convert(userRepository.save(user), User.class);
  }

  @Override
  public User updateUser(UserEntity user) {
    Optional<UserEntity> optionalUserEntity = userRepository.findById(user.getUserId());
    if (optionalUserEntity.isPresent()) {
      UserEntity userEntity = optionalUserEntity.get();
      userEntity = conversionServices.convert(user, UserEntity.class);
      userRepository.save(userEntity);
      return conversionServices.convert(userEntity, User.class);
    } else {
      throw new UserException("User Not found for ID : " + user.getUserId());
    }
  }

  @Override
  public List<UserEntity> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUserById(Long userId) {
    Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
    if (optionalUserEntity.isPresent()) {
      UserEntity userEntity = optionalUserEntity.get();
      return conversionServices.convert(userEntity, User.class);
    } else {
      throw new UserException("User Not found for ID : " + userId);
    }
  }

  @Override
  public void deleteUser(Long userId) {
    Optional<UserEntity> optionalUserEntity = userRepository.findById(userId);
    if (optionalUserEntity.isPresent()) {
      UserEntity userEntity = optionalUserEntity.get();
      userRepository.delete(userEntity);
    } else {
      throw new UserException("User Not found for ID : " + userId);
    }

  }
}
