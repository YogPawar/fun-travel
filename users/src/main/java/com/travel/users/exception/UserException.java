package com.travel.users.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class UserException extends RuntimeException {

  public UserException(String message) {
    super(message);
  }

  public UserException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
