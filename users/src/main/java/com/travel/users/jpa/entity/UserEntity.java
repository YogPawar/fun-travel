package com.travel.users.jpa.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "t_user")
@Getter
@Setter
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long userId;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @Column(name = "email")
  private String email;

  @Column(name = "vehicle_type")
  private String vehicleType;

  @Column(name = "base_price")
  private Integer basePrice;

  @Column(name = "fare_distance")
  private Long fareDistance;

  @CreationTimestamp
  @Column(name = "createdAt")
  private Date createdAt;

  @Column(name = "updateAt")
  @CreationTimestamp
  private Date updateAt;

}
