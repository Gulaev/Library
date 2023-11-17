package com.gulaev.interfaces;

import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import com.gulaev.user.LibraryUser;
import java.util.List;

public interface Book {

  Integer getPriceWithDiscount(LibraryUser user);

  String getTitle();

  String getAuthor();

  List<Tag> getTags();

  Genre getGenre();

}
