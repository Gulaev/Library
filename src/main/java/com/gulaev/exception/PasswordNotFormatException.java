package com.gulaev.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PasswordNotFormatException extends Exception {
  private static final Logger LOG = LogManager.getLogger(PasswordNotFormatException.class);


  public PasswordNotFormatException(String message) {
    super(message);
    LOG.error("Password dont have need");
  }
}
