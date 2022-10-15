package com.travel.users.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

  private String name;

  private String surname;

  private String email;

  private String vehicleType;

  private Integer basePrice;

  private Long fareDistance;

}
