package com.gulaev.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PriceCantByZeroException extends Throwable {

  private static final Logger LOG = LogManager.getLogger(PriceCantByZeroException.class);

  public PriceCantByZeroException(String s) {
    super(s);
    LOG.error("Price cant by one or less");
  }
}
