package com.gulaev.user;

import com.gulaev.book.Book;
import java.util.List;
import java.util.Set;

public abstract class User {
  protected Integer id;
  protected String username;
  protected String email;
  protected String password;
  protected String firstname;
  protected String lastname;

  public abstract void changePassword(String currentPassword, String newPassword);

}
