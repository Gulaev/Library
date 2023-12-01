package com.gulaev.interfaces.function;

@FunctionalInterface
public interface Builder<T> {

  public abstract T build();

}
