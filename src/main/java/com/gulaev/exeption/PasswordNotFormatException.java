package com.gulaev.exeption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PasswordNotFormatException extends Exception {
  private static final Logger log = LogManager.getLogger(PasswordNotFormatException.class);


  public PasswordNotFormatException(String message) {
    super(message);
    log.error("Password dont have need");
  }
}
