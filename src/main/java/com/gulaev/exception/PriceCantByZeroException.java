package com.gulaev.exception;

public class PriceCantByZeroException extends Throwable {

  public PriceCantByZeroException(String message) {
    super(message);
  }
}
