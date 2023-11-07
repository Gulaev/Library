package com.gulaev.user;

import com.gulaev.book.Book;
import java.util.List;
import java.util.Objects;

public class LibraryUser extends User {

  private Integer id;
  private String username;
  private String email;
  private String password;
  private List<Book> wishlist;
  private List<Book> boughtBooks;
  private List<Book> bag;
  private String firstName;
  private String lastName;

  public LibraryUser(Integer id, String username, String email, String password, List<Book> wishlist,
      List<Book> boughtBooks, List<Book> bag, String firstName, String lastName) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.wishlist = wishlist;
    this.boughtBooks = boughtBooks;
    this.bag = bag;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public LibraryUser() {}

  @Override
  public void changePassword(String currentPassword, String newPassword) {
    if (this.password!=null && this.password.equals(currentPassword)) {
      this.password = newPassword;
    } else {
      System.out.println("Password dosent exist or current password not matches");
    }
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

  public void setWishlist(List<Book> wishlist) {
    this.wishlist = wishlist;
  }

  public void setBoughtBooks(List<Book> boughtBooks) {
    this.boughtBooks = boughtBooks;
  }

  public void setBag(List<Book> bag) {
    this.bag = bag;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
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

  public List<Book> getWishlist() {
    return wishlist;
  }

  public List<Book> getBoughtBooks() {
    return boughtBooks;
  }

  public List<Book> getBag() {
    return bag;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public String toString() {
    return "LibraryUser{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", wishlist=" + wishlist +
        ", boughtBooks=" + boughtBooks +
        ", bag=" + bag +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LibraryUser that = (LibraryUser) o;
    return Objects.equals(id, that.id) && Objects.equals(username, that.username)
        && Objects.equals(email, that.email) && Objects.equals(password,
        that.password) && Objects.equals(wishlist, that.wishlist)
        && Objects.equals(boughtBooks, that.boughtBooks) && Objects.equals(bag,
        that.bag) && Objects.equals(firstName, that.firstName) && Objects.equals(
        lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, email, password, wishlist, boughtBooks, bag, firstName,
        lastName);
  }
}
