package com.gulaev.user;

import com.gulaev.exeption.PasswordNotFormatException;

public abstract class User {
  protected Integer id;
  protected String username;
  protected String email;
  protected String password;
  protected String firstname;
  protected String lastname;


  public void changePassword(String currentPassword, String newPassword)
      throws PasswordNotFormatException {
    if (this.password != null && this.password.equals(currentPassword)) {
      if (newPassword.matches("^(?=.*\\d)(?=.*[A-Z]).{1,7}$")) {
        this.password = newPassword;
      } else {
        throw new PasswordNotFormatException("New password format is not valid");
      }
    } else {
      System.out.println("Password doesn't exist or current password doesn't match");
    }
  }

}
