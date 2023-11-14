package com.gulaev.repository;

import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.gulaev.book.BookItem;

public final class BookRepository {
  private static final List<BookItem> BOOK_ITEMS = new ArrayList<>();

  static {
    String[] authors = {"Nick", "John", "Sam", "Alex", "Tom"};
    for (int i = 1; i <= 150; i++) {
      BOOK_ITEMS.add(new BookItem(i, "Title" + i, authors[i % authors.length], "Description" + i, i * 10,
          Arrays.asList(Tag.values()[i % Tag.values().length], Tag.values()[(i+1) %
                  Tag.values().length], Tag.values()[(i+2) % Tag.values().length],
              Tag.values()[(i+3) % Tag.values().length], Tag.values()[(i+4) %
                  Tag.values().length]),
          Genre.values()[i % Genre.values().length]));
    }
  }

  public static final List<BookItem> getAllBooks() {
    return BOOK_ITEMS;
  }
}
