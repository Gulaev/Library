package com.gulaev.thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThread extends Thread {
  private final Logger LOGGER = LogManager.getLogger(MyThread.class);

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      LOGGER.info("My Thread running " + i);
    }
  }
}
