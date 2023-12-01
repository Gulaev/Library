package com.gulaev.interfaces.function;

@FunctionalInterface
public interface Calculator<T, V> {

  void calculate(T t, V v);

}
