package com.gulaev;

import com.gulaev.book.BookItem;
import com.gulaev.book.OnlineBook;
import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import com.gulaev.linkd.Linkd;
import com.gulaev.linkd.LinkdList;
import com.gulaev.service.BookRecommendationService;
import com.gulaev.service.BookService;
import com.gulaev.service.UserService;
import com.gulaev.user.LibraryUser;
import java.util.Arrays;
import java.util.Set;


public class Main {

  public static void main(String[] args) {

    //Create a bookItem pool
    BookItem bookItem1 = BookService.createNewBookItem("Nick",
        "An intriguing novel by Nick, delving into the complexities of human nature and the relentless pursuit of truth. With eloquent prose and engaging storytelling, this book captivates readers with its rich narrative and thought-provoking themes. Set in a world filled with suspense and mystery, the story unfolds, enthralling readers page by page.",
        "Book", 10, Genre.FANTASY, Arrays.asList(Tag.WAR, Tag.COMEDY));
    BookItem bookItem2 = new BookItem(2, "Title2", "John", "Description2", 20,
        Arrays.asList(Tag.HISTORY, Tag.WAR), Genre.MYSTERY);
    BookItem bookItem3 = new BookItem(3, "Title3", "Nick", "Description3", 30,
        Arrays.asList(Tag.COMEDY, Tag.HISTORY), Genre.MYSTERY);

    //Testing online book pool
    OnlineBook onlineBook = OnlineBook.builder().setTitle("Title").setId(1).setAuthor("Nithe")
        .setCover("not path").setDescription("Description").setGenre(Genre.FANTASY).setPrice(300)
        .setTags(Arrays.asList(Tag.DRAMA, Tag.HISTORY)).build();

    LibraryUser user = UserService.createNewLibraryUser("suser", "email@email.com", "John", "Doe",
        "Abc1234");

    user.setWishlist(Arrays.asList(bookItem1, bookItem2));
    user.setBoughtBooks(Arrays.asList(bookItem3));

    user = UserService.changePasswordToUser(user, "Abc1234", "Abc1235");

    Set<BookItem> recommendedBookItems = BookRecommendationService.findBookByPreferences(user);
    System.out.println(onlineBook.toString());

    Linkd<Integer> lol = new LinkdList<>();

    lol.add(1);
    lol.add(2);
    lol.add(3);
    lol.add(4);

    System.out.println("aaaaaaaaaaa");

//    lol.deleteLast();
    lol.add(1, 4);
    for (Integer i : lol) {
      System.out.println(i);
    }
    System.out.println(lol.length());


  }
}