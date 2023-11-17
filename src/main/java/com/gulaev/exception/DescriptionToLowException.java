package com.gulaev.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DescriptionToLowException extends Exception {

  private static final Logger LOG = LogManager.getLogger(DescriptionToLowException.class);

  public DescriptionToLowException(String message) {
    super(message);
    LOG.error("Description must by more then 50 symbols");
  }
}
