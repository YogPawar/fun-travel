package com.travel.users.api;

import com.travel.users.jpa.entity.UserEntity;
import com.travel.users.model.User;
import com.travel.users.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private IUserService iUserService;

  @GetMapping
  public ResponseEntity<List<UserEntity>> getAllUsers() {
    return ResponseEntity.ok().body(iUserService.getAllUsers());
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody UserEntity userEntity) {
    return ResponseEntity.ok().body(iUserService.createUser(userEntity));
  }

  @PutMapping("/{userId}")
  public ResponseEntity<User> updateUser(@PathVariable Long userId,
      @RequestBody UserEntity userEntity) {
    return ResponseEntity.ok().body(iUserService.createUser(userEntity));
  }

  @DeleteMapping
  public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
    iUserService.deleteUser(userId);
    return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK);
  }

  @GetMapping("/{userId}")
  public ResponseEntity<User> getUserById(@PathVariable Long userId) {
    return ResponseEntity.ok().body(iUserService.getUserById(userId));
  }


}
