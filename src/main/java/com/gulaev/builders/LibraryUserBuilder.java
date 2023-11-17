package com.gulaev.builders;

import com.gulaev.exception.EmailNotFormatException;
import com.gulaev.exception.PasswordNotFormatException;
import com.gulaev.interfaces.Builder;
import com.gulaev.user.LibraryUser;

public class LibraryUserBuilder implements Builder<LibraryUser> {

  private Integer id;
  private String username;
  private String firstName;
  private String lastName;
  private String email;
  private String password;

  public LibraryUserBuilder() {
  }

  public LibraryUserBuilder setUsername(String username) {
    this.username = username;
    return this;
  }

  public LibraryUserBuilder setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public LibraryUserBuilder setEmail(String email) throws EmailNotFormatException {

    if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
      this.email = email;
    } else {
      throw new EmailNotFormatException("Invalid email format");
    }
    return this;
  }

  public LibraryUserBuilder setPassword(String password) throws PasswordNotFormatException {

    if (password.matches("^(?=.*\\d)(?=.*[A-Z]).{7,}$")) {
      this.password = password;
    } else {
      throw new PasswordNotFormatException("Invalid password format");
    }
    return this;
  }


  public LibraryUserBuilder setId(Integer id) {
    this.id = id;
    return this;
  }


  public LibraryUserBuilder setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }


  public LibraryUser build() {
    return new LibraryUser(id, username, email, password, firstName, lastName);
  }
}