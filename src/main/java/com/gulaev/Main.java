package com.gulaev;

import com.gulaev.book.BookItem;
import com.gulaev.book.OnlineBook;
import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import com.gulaev.service.BookRecommendationService;
import com.gulaev.service.BookService;
import com.gulaev.service.UserService;
import com.gulaev.user.LibraryUser;
import java.util.Arrays;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

  private static final Logger log = LogManager.getLogger(Main.class);

  public static void main(String[] args) {

    BookItem bookItem1 = BookService.createNewBookItem("Nick", "Descriptiojkahfkajhfkjahasflkasjflkajsflkasjflkjaslkfjaslkfjlasfkashfkahsfkjhaskfhasn1", "Book", 10,
        Genre.FANTASY, Arrays.asList(Tag.WAR, Tag.COMEDY));
    BookItem bookItem2 = new BookItem(2, "Title2", "John", "Description2", 20,
        Arrays.asList(Tag.HISTORY, Tag.WAR), Genre.MYSTERY);
    BookItem bookItem3 = new BookItem(3, "Title3", "Nick", "Description3", 30,
        Arrays.asList(Tag.COMEDY, Tag.HISTORY), Genre.MYSTERY);

    OnlineBook onlineBook = OnlineBook.builder()
        .setTitle("Title")
        .setId(1).setAuthor("Nithe").setCover("not path")
        .setDescription("Description").setGenre(Genre.FANTASY)
        .setPrice(300).setTags(Arrays.asList(Tag.DRAMA, Tag.HISTORY)).build();


    LibraryUser user =
        UserService.createNewLibraryUser("suser", "email@email.com", "John", "Doe", "Abc1234");

    user.setWishlist(Arrays.asList(bookItem1, bookItem2));
    user.setBoughtBooks(Arrays.asList(bookItem3));

    user = UserService.changePasswordToUser(user, "Abc1234", "Abc1235");


    Set<BookItem> recommendedBookItems = BookRecommendationService.findBookByPreferences(user);
    System.out.println(onlineBook.toString());
  }

}