package com.gulaev.service;

import com.gulaev.exception.EmailNotFormatException;
import com.gulaev.exception.PasswordDidntMatchException;
import com.gulaev.exception.PasswordNotFormatException;
import com.gulaev.user.LibraryUser;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserService {

      private static final Logger LOG = LogManager.getLogger(UserService.class);

      public static LibraryUser createNewLibraryUser(String username, String email, String firstName,
          String lastName, String password) {
        Random random = new Random();
        try {
          LibraryUser user  = LibraryUser.builder().setId(random.nextInt()).setUsername(username)
              .setFirstName(firstName)
              .setLastName(lastName).setPassword(password).setEmail(email).build();
        return user;

        } catch (PasswordNotFormatException e) {
          LOG.error(e.getMessage());
          return new LibraryUser();

        } catch (EmailNotFormatException e) {
          LOG.error(e.getMessage());
          return new LibraryUser();
        }

      }

      public static LibraryUser changePasswordToUser(LibraryUser user, String currentPassword, String newPassword) {
        try {
          user.changePassword(user,currentPassword, newPassword);
          return user;

        } catch (PasswordNotFormatException e) {
          LOG.error("Password need to be format, min 6 symbols and one digit");
          return user;

        } catch (PasswordDidntMatchException e) {
          LOG.error("Password didnt match, check and try again");
          return user;
        }
      }
}
