package com.travel.users.utils;

import com.travel.users.converter.UserEntityToEntity;
import com.travel.users.converter.UserEntityToUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableAsync
public class UserConfiguration implements WebMvcConfigurer {

  @Autowired
  UserEntityToUser userEntityToUser;

  @Autowired
  UserEntityToEntity userEntityToEntity;

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(userEntityToEntity);
    registry.addConverter(userEntityToUser);
  }
}
