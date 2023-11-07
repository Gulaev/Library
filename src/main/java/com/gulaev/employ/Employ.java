package com.gulaev.employ;

import com.gulaev.user.User;

public class Employ extends User {

  private Integer id;
  private String username;
  private String email;
  private String password;
  private String firstname;
  private String lastname;

  @Override
  public void changePassword(String currentPassword, String newPassword) {
    if (this.password!=null && this.password.equals(currentPassword)) {
      this.password = newPassword;
    } else {
      System.out.println("Password dosent exist or current password not matches");
    }
  }
}
