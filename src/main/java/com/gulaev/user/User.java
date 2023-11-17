package com.gulaev.user;

import com.gulaev.exception.PasswordDidntMatchException;
import com.gulaev.exception.PasswordNotFormatException;

public abstract class User {
  protected Integer id;
  protected String username;
  protected String email;
  protected String password;
  protected String firstname;
  protected String lastname;


  public User changePassword(User user, String currentPassword, String newPassword)
      throws PasswordNotFormatException, PasswordDidntMatchException {
    if (user.password != null && user.password.equals(currentPassword)) {
      if (newPassword.matches("^(?=.*\\d)(?=.*[A-Z]).{1,7}$")) {
        user.password = newPassword;
        return user;
      } else {
        throw new PasswordNotFormatException("New password format is not valid");
      }
    } else {
      throw new PasswordDidntMatchException("Password doesn't exist or current password doesn't match");
    }
  }

}
