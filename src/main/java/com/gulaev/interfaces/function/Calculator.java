package com.gulaev.interfaces.function;

@FunctionalInterface
public interface Calculator<T, V> {

  Integer calculate(T t, V v);

}
