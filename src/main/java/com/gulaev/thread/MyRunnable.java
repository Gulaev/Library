package com.gulaev.thread;

public class MyRunnable implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      System.out.println("My Runnable running " + i);
    }
  }
}
