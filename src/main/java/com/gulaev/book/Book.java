package com.gulaev.book;

import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import com.gulaev.user.LibraryUser;
import com.gulaev.user.User;
import java.util.List;

public interface Book {

  Integer getPriceWithDiscount(LibraryUser user);
  String getTitle();
  String getAuthor();
  List<Tag> getTags();
  Genre getGenre();

}
