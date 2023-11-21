package com.gulaev.linkd;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkdList<T> implements Linkd<T> {

  private Node<T> head;

  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator();
  }

  public void add(T data) {
    Node<T> node = new Node<>(data);
    if (head == null) {
      head = node;
    } else {
      Node<T> current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = node;
    }
  }


  public void add(T data, int index) {
    if (index < 0) {
      throw new IndexOutOfBoundsException("Index cannot be negative");
    }
    if (index == 0) {
      Node<T> newNode = new Node<>(data);
      newNode.next = head;
      head = newNode;
    }
    if (head == null) {
      throw new NoSuchElementException();
    }
    Node<T> current = head;
    int currentIndex = 0;

    while (current != null && currentIndex < index - 1) {
      currentIndex++;
      current = current.next;
    }
    if (current == null) {
      throw new IndexOutOfBoundsException("Index is out of bounds");
    }
    Node<T> newNode = new Node<>(data);
    newNode.next = current.next;
    current.next = newNode;
  }

  public int length() {
    if (head == null) {
      throw new NoSuchElementException();
    }
    int length = 1;
    Node<T> current = head;
    while (current.next != null) {
      length += 1;
      current = current.next;
    }
    return length;
  }

  @Override
  public void delete(T data) {
    if (head == null) {
      return;
    }

    if (head.item.equals(data)) {
      head = head.next;
      return;
    }

    Node<T> current = head;
    Node<T> previous = null;

    while (current != null && !current.item.equals(data)) {
      previous = current;
      current = current.next;
    }

    if (current == null) {
      return;
    }

    previous.next = current.next;
  }


  @Override
  public T getFirst() {
    final Node<T> f = head;
    if (f == null) {
      throw new NoSuchElementException();
    }
    return f.next.item;
  }

  @Override
  public T getLast() {
    if (head == null) {
      return null;
    }
    Node<T> current = head;
    while (current.next != null) {
      current = current.next;
    }
    return current.item;
  }

  public void deleteFirst() {
    final Node<T> first = head;
    if (first == null) {
      throw new NoSuchElementException();
    }
    head = head.next;
  }

  @Override
  public void clear() {
    head = null;
  }

  @Override
  public void deleteLast() {
    if (head == null) {
      throw new NoSuchElementException();
    }
    Node<T> current = head;
    while (current.next.next != null) {
      current = current.next;
    }
    current.next = null;
  }


  private static class Node<T> {

    private final T item;
    private Node<T> next;

    public Node(T item) {
      this.item = item;
      this.next = null;
    }
  }

  private class LinkedListIterator implements Iterator<T> {

    private Node<T> current;

    public LinkedListIterator() {
      current = head;
    }

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      T data = current.item;
      current = current.next;
      return data;
    }
  }
}
