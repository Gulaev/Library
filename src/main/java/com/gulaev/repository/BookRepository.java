package com.gulaev.repository;

import com.gulaev.book.BookItem;
import com.gulaev.enums.Genre;
import com.gulaev.enums.Stores;
import com.gulaev.enums.Tag;
import com.gulaev.enums.Warehouses;
import com.gulaev.linkd.Linkd;
import com.gulaev.linkd.LinkdList;
import java.util.Arrays;

public final class BookRepository {

  private static final Linkd<BookItem> BOOK_ITEMS = new LinkdList<>();

  static {
    String[] authors = {"Nick", "John", "Sam", "Alex", "Tom"};
    for (int i = 1; i <= 150; i++) {
      BOOK_ITEMS.add(
          new BookItem(i, "Title" + i, authors[i % authors.length], "Description" + i, i * 10,
              Arrays.asList(Tag.values()[i % Tag.values().length], Tag.values()[(i + 1) %
                      Tag.values().length], Tag.values()[(i + 2) % Tag.values().length],
                  Tag.values()[(i + 3) % Tag.values().length], Tag.values()[(i + 4) %
                      Tag.values().length]),
              Genre.values()[i % Genre.values().length], Warehouses.KYIV, Stores.KYIV
              ));
    }
  }

  public static Linkd<BookItem> getAllBooks() {
    return BOOK_ITEMS;
  }
}
