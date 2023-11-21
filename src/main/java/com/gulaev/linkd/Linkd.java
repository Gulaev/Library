package com.gulaev.linkd;

public interface Linkd<T> extends Iterable<T> {

  void delete(T data);

  void add(T data);

  void add(T data, int index);

  T getFirst();

  T getLast();

  void deleteLast();

  void deleteFirst();

  void clear();

  int length();
}
