package com.gulaev.user;

import com.gulaev.interfaces.Book;
import com.gulaev.builders.LibraryUserBuilder;
import com.gulaev.exception.PasswordDoNotMatchException;
import com.gulaev.exception.InvalidPasswordFormatException;
import com.gulaev.interfaces.Customer;
import java.util.List;
import java.util.Objects;

public class LibraryUser extends User implements Customer {

  private Integer id;
  private String username;
  private String email;
  private String password;
  private List<Book> wishlist;
  private List<Book> boughtBookItems;
  private List<Book> bag;
  private String firstName;
  private String lastName;
  private Integer discountCount;

  public LibraryUser() {
  }

  public LibraryUser(Integer id, String username, String email, String password,
      List<Book> wishlist,
      List<Book> boughtBookItems, List<Book> bag, String firstName, String lastName,
      Integer discountCount) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.wishlist = wishlist;
    this.boughtBookItems = boughtBookItems;
    this.bag = bag;
    this.firstName = firstName;
    this.lastName = lastName;
    this.discountCount = discountCount;
  }

  public LibraryUser(Integer id, String username, String email,
      String password, String firstName, String lastName) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public static LibraryUserBuilder builder() {
    return new LibraryUserBuilder();
  }

  @Override
  public Integer countBooksOnWishlist() {
    Integer booksPrices = 0;
    if (this.wishlist != null) {
      for (Book book : this.wishlist) {
        booksPrices += book.getPriceWithDiscount(this);
      }
    }
    return booksPrices;
  }

  @Override
  public Integer countBag() {
    Integer booksPrices = 0;
    if (this.bag != null) {
      for (Book book : this.bag) {
        booksPrices += book.getPriceWithDiscount(this);
      }
    }
    return booksPrices;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Book> getWishlist() {
    return wishlist;
  }

  public void setWishlist(List<Book> wishlist) {
    this.wishlist = wishlist;
  }

  public List<Book> getBoughtBooks() {
    return boughtBookItems;
  }

  public void setBoughtBooks(List<Book> boughtBookItems) {
    this.boughtBookItems = boughtBookItems;
  }

  public List<Book> getBag() {
    return bag;
  }

  public void setBag(List<Book> bag) {
    this.bag = bag;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "LibraryUser{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", wishlist=" + wishlist +
        ", boughtBooks=" + boughtBookItems +
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
        && Objects.equals(boughtBookItems, that.boughtBookItems) && Objects.equals(bag,
        that.bag) && Objects.equals(firstName, that.firstName) && Objects.equals(
        lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, email, password, wishlist, boughtBookItems, bag, firstName,
        lastName);
  }

  public Integer getDiscountCount() {
    return discountCount;
  }

  public void setDiscountCount(Integer discountCount) {
    this.discountCount = discountCount;
  }

  @Override
  public User changePassword(User user, String currentPassword, String newPassword)
      throws InvalidPasswordFormatException, PasswordDoNotMatchException {
    if (this.password != null && this.password.equals(currentPassword)) {
      if (newPassword.matches("^(?=.*\\d)(?=.*[A-Z]).{1,7}$")) {
        this.password = newPassword;
        return this;
      } else {
        throw new InvalidPasswordFormatException("The new password format is invalid");
      }
    } else {
      throw new PasswordDoNotMatchException(
          "Password doesn't exist or current password doesn't match");
    }
  }

}
