package com.gulaev.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmailNotFormatException extends Exception {
  private static final Logger LOG = LogManager.getLogger(EmailNotFormatException.class);

  public EmailNotFormatException(String message) {
    super(message);
    LOG.error(message);
  }
}
