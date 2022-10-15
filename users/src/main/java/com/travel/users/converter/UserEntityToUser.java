package com.travel.users.converter;

import com.travel.users.jpa.entity.UserEntity;
import com.travel.users.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToUser implements Converter<UserEntity, User> {

  @Override
  public User convert(UserEntity userEntity) {
    User user = new User();
    user.setName(userEntity.getName());
    user.setEmail(userEntity.getEmail());
    user.setSurname(userEntity.getSurname());
    user.setBasePrice(userEntity.getBasePrice());
    user.setVehicleType(userEntity.getVehicleType());
    user.setFareDistance(userEntity.getFareDistance());
    return user;
  }
}
