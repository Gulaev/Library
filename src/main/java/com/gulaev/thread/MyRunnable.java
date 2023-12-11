package com.gulaev.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyRunnable implements Runnable {
  private final Logger LOGGER = LogManager.getLogger(MyRunnable.class);


  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      LOGGER.info("My Runnable running " + i);
    }
  }
}
