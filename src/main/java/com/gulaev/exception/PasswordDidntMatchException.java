package com.gulaev.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PasswordDidntMatchException extends Exception{
  private static final Logger LOG = LogManager.getLogger(PasswordDidntMatchException.class);

  public PasswordDidntMatchException(String message) {
    super(message);
    LOG.error("Password didnt match");
  }
}
