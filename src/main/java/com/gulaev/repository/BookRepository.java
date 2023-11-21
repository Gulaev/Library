package com.gulaev.repository;

import com.gulaev.book.BookItem;
import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import com.gulaev.linkd.LinkdList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class BookRepository {

  private static final LinkdList<BookItem> BOOK_ITEMS = new LinkdList<>();

  static {
    String[] authors = {"Nick", "John", "Sam", "Alex", "Tom"};
    for (int i = 1; i <= 150; i++) {
      BOOK_ITEMS.add(
          new BookItem(i, "Title" + i, authors[i % authors.length], "Description" + i, i * 10,
              Arrays.asList(Tag.values()[i % Tag.values().length], Tag.values()[(i + 1) %
                      Tag.values().length], Tag.values()[(i + 2) % Tag.values().length],
                  Tag.values()[(i + 3) % Tag.values().length], Tag.values()[(i + 4) %
                      Tag.values().length]),
              Genre.values()[i % Genre.values().length]));
    }
  }

  public static LinkdList<BookItem> getAllBooks() {
    return BOOK_ITEMS;
  }
}
