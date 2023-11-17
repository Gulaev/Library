package com.gulaev.exception;

public class PasswordDidntMatchException extends Exception {

  public PasswordDidntMatchException(String message) {
    super(message);
  }
}
