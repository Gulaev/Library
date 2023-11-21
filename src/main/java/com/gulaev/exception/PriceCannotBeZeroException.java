package com.gulaev.exception;

public class PriceCannotBeZeroException extends Throwable {

  public PriceCannotBeZeroException(String message) {
    super(message);
  }
}
