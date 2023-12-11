package com.gulaev.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {

  private static ConnectionPool instance;
  private BlockingQueue<MockConnection> pool;

  private ConnectionPool(int capacity) {
    pool = new LinkedBlockingQueue<>(capacity);
    for (int i = 0; i < 5; i++) {
      pool.add(new MockConnection());
    }
  }

  public static synchronized ConnectionPool getInstance(int capacity) {
    if (instance == null) {
      instance = new ConnectionPool(capacity);
    }
    return instance;
  }

  public MockConnection getConnection() throws InterruptedException {
    return pool.take();
  }

  public void releaseConnection(MockConnection connection) {
    pool.add(connection);
  }
}