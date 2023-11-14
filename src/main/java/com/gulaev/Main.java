package com.gulaev;

import com.gulaev.book.BookItem;
import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import com.gulaev.exeption.PasswordNotFormatException;
import com.gulaev.service.BookRecommendationService;
import com.gulaev.user.LibraryUser;
import java.util.Arrays;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

  private static final Logger log = LogManager.getLogger(Main.class);

  public static void main(String[] args) {

    BookItem bookItem1 = new BookItem(1, "Title1", "Nick", "Description1", 10,
    
        Arrays.asList(Tag.WAR, Tag.COMEDY), Genre.FANTASY);
    BookItem bookItem2 = new BookItem(2, "Title2", "John", "Description2", 20,
        Arrays.asList(Tag.HISTORY, Tag.WAR), Genre.MYSTERY);
    BookItem bookItem3 = new BookItem(3, "Title3", "Nick", "Description3", 30,
        Arrays.asList(Tag.COMEDY, Tag.HISTORY), Genre.MYSTERY);


    log.error("Hello");

    LibraryUser user = new LibraryUser();
    user.setWishlist(Arrays.asList(bookItem1, bookItem2));
    user.setBoughtBooks(Arrays.asList(bookItem3));

    try {
      user.changePassword(null, null);
    } catch (PasswordNotFormatException e) {
      throw new RuntimeException(e);
    }

    Set<BookItem> recommendedBookItems = BookRecommendationService.findBookByPreferences(user);

    recommendedBookItems.forEach(System.out::println);
  }

}