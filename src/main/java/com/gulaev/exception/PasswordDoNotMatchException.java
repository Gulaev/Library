package com.gulaev.exception;

public class PasswordDoNotMatchException extends Exception {

  public PasswordDoNotMatchException(String message) {
    super(message);
  }
}
