package com.gulaev.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ThreadTest {

  public void testThreadSubmit() {
    ExecutorService executorService = Executors.newFixedThreadPool(7);
    ConnectionPool connectionPool = ConnectionPool.getInstance(5);

    for (int i = 0; i < 7; i++) {
      executorService.submit(() -> {
        try {
          MockConnection connection = connectionPool.getConnection();
          connection.connect();
          System.out.println("Got connection: " + connection);
          Thread.sleep(1000); // simulate work
          connectionPool.releaseConnection(connection);
          System.out.println("Released connection: " + connection);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
    }
    executorService.shutdown();
  }

  public void testThreadFuture() {
    ExecutorService executorService = Executors.newFixedThreadPool(7);
    ConnectionPool connectionPool = ConnectionPool.getInstance(5);

    for (int i = 0; i < 7; i++) {
      CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
        try {
          MockConnection connection = connectionPool.getConnection();
          String isConnect = connection.connect();
          System.out.println("Got connection: " + connection);
          Thread.sleep(1000); // simulate work
          connectionPool.releaseConnection(connection);
          System.out.println("Released connection: " + connection);
          return isConnect;

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        return null;
      });
      try {
        System.out.println(future.get());
      } catch (InterruptedException | ExecutionException e) {
        throw new RuntimeException(e);
      }
    }
    executorService.shutdown();
  }
}
