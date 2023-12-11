package com.gulaev.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ThreadTest {

  private final Logger LOGGER = LogManager.getLogger(ThreadTest.class);

  public void testThreadSubmit() {
    ExecutorService executorService = Executors.newFixedThreadPool(7);
    ConnectionPool connectionPool = ConnectionPool.getInstance(5);

    for (int i = 0; i < 7; i++) {
      executorService.submit(() -> {
        try {
          MockConnection connection = connectionPool.getConnection();
          connection.connect();
          LOGGER.info("Got connection: " + connection);
          Thread.sleep(1000); // simulate work
          connectionPool.releaseConnection(connection);
          LOGGER.info("Released connection: " + connection);
        } catch (InterruptedException e) {
          LOGGER.error(e.getMessage());
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
      CompletionStage<String> future = CompletableFuture.supplyAsync(() -> {
        try {
          MockConnection connection = connectionPool.getConnection();
          String isConnect = connection.connect();
          LOGGER.info("Got connection: " + connection);
          Thread.sleep(1000); // simulate work
          connectionPool.releaseConnection(connection);
          LOGGER.info("Released connection: " + connection);
          return isConnect;

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        return null;
      });
      try {
        LOGGER.info(future.toCompletableFuture().get());
      } catch (InterruptedException | ExecutionException e) {
        LOGGER.error(e.getMessage());
        throw new RuntimeException(e);
      }
    }
    executorService.shutdown();
  }
}
