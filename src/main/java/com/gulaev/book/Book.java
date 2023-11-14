package com.gulaev.book;

import com.gulaev.user.LibraryUser;
import com.gulaev.user.User;

public interface Book {

  Integer getPriceWithDiscount(LibraryUser user);
  String getTitle();

}
