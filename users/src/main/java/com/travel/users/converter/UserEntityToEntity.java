package com.travel.users.converter;

import com.travel.users.jpa.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToEntity implements Converter<UserEntity, UserEntity> {

  @Override
  public UserEntity convert(UserEntity source) {
    UserEntity updatedEntity = new UserEntity();
    updatedEntity.setEmail(source.getEmail());
    updatedEntity.setName(source.getName());
    updatedEntity.setSurname(source.getSurname());
    updatedEntity.setBasePrice(source.getBasePrice());
    updatedEntity.setFareDistance(source.getFareDistance());
    updatedEntity.setVehicleType(source.getVehicleType());
    return updatedEntity;
  }
}
