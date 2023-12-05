package com.gulaev.user;

import com.gulaev.enums.Seasons;
import com.gulaev.exception.PasswordDoNotMatchException;
import com.gulaev.exception.InvalidPasswordFormatException;

public abstract class User {
  protected Integer id;
  protected String username;
  protected String email;
  protected String password;
  protected String firstname;
  protected String lastname;
  protected Seasons workStartSeason;


  public User changePassword(User user, String currentPassword, String newPassword)
      throws InvalidPasswordFormatException, PasswordDoNotMatchException {
    if (user.password != null && user.password.equals(currentPassword)) {
      if (newPassword.matches("^(?=.*\\d)(?=.*[A-Z]).{1,7}$")) {
        user.password = newPassword;
        return user;
      } else {
        throw new InvalidPasswordFormatException("New password format is not valid");
      }
    } else {
      throw new PasswordDoNotMatchException("Password doesn't exist or current password doesn't match");
    }
  }

}
