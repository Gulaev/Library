package com.gulaev.service;

import com.gulaev.exception.EmailNotFormatException;
import com.gulaev.exception.InvalidPasswordFormatException;
import com.gulaev.exception.PasswordDoNotMatchException;
import com.gulaev.user.LibraryUser;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserService {

  private static final Logger LOGGER = LogManager.getLogger(UserService.class);

  public static LibraryUser createNewLibraryUser(String username, String email, String firstName,
      String lastName, String password) {
    LOGGER.info("Start createNewLibraryUser");
    Random random = new Random();
    LibraryUser user = new LibraryUser();

    try {
      user = LibraryUser.builder().setId(random.nextInt()).setUsername(username)
          .setFirstName(firstName)
          .setLastName(lastName).setPassword(password).setEmail(email).build();
    } catch (InvalidPasswordFormatException | EmailNotFormatException e) {
      LOGGER.error(e.getMessage());
    }
    LOGGER.info("Method createNewLibraryUser executed");
    return user;
  }

  public static LibraryUser changePasswordToUser(LibraryUser user, String currentPassword,
      String newPassword) {
    LOGGER.info("Start changePasswordToUser");
    try {
      user.changePassword(user, currentPassword, newPassword);

    } catch (InvalidPasswordFormatException | PasswordDoNotMatchException e) {
      LOGGER.error(e.getMessage());
    }
    LOGGER.info("Method changePasswordToUser executed");
    return user;
  }
}
