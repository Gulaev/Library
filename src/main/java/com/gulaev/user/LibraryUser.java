package com.gulaev.user;

import com.gulaev.book.Book;
import java.util.List;

public class LibraryUser implements User {

  private Integer id;
  private String username;
  private String email;
  private String password;
  private List<Book> wantish;
  private List<Book> boughtBooks;
  private List<Book> bag;
  private String firstname;
  private String lastname;

  public LibraryUser(Integer id, String username, String email, String password, List<Book> wantish,
      List<Book> boughtBooks, List<Book> bag, String firstname, String lastname) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.wantish = wantish;
    this.boughtBooks = boughtBooks;
    this.bag = bag;
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public LibraryUser() {

  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setWantish(List<Book> wantish) {
    this.wantish = wantish;
  }

  public void setBoughtBooks(List<Book> boughtBooks) {
    this.boughtBooks = boughtBooks;
  }

  public void setBag(List<Book> bag) {
    this.bag = bag;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public Integer getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public List<Book> getWantish() {
    return wantish;
  }

  public List<Book> getBoughtBooks() {
    return boughtBooks;
  }

  public List<Book> getBag() {
    return bag;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }
}
