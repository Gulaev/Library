package com.gulaev.interfaces.function;

@FunctionalInterface
public interface Сonnector<T, V, R> {

  R connect(T t, V v);

}
