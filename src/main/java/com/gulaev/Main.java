package com.gulaev;

import com.gulaev.book.BookItem;
import com.gulaev.book.OnlineBook;
import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import com.gulaev.file.FileReader;
import com.gulaev.interfaces.function.Builder;
import com.gulaev.interfaces.function.Calculator;
import com.gulaev.interfaces.function.Сonnector;
import com.gulaev.linkd.Linkd;
import com.gulaev.linkd.LinkdList;
import com.gulaev.service.BookRecommendationService;
import com.gulaev.service.BookService;
import com.gulaev.service.UserService;
import com.gulaev.user.LibraryUser;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

  private static final Logger LOGGER = LogManager.getLogger(Main.class);

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

    Linkd<Integer> integerLinkdList = new LinkdList<>();

    integerLinkdList.add(1);
    integerLinkdList.add(2);
    integerLinkdList.add(3);
    integerLinkdList.add(4);
    integerLinkdList.add(1, 4);

    LOGGER.info(integerLinkdList);

//    recommendedBookItems.forEach();

    try {
      System.out.println(FileReader.getWordsFromFile());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    //Testng lambda functions

    Calculator<Integer, Integer> run2 = (Integer d, Integer b) ->
        System.out.println(d + b);

    Builder<String> builder = () -> new String("Builder works");
    String build = builder.build();

    Сonnector<Integer, Integer, Long> connector = (Integer a, Integer b) -> {
      String valueOfSum = String.valueOf(a + b);
      Long bb = Long.parseLong(valueOfSum);
      return bb;
    };


  }
}