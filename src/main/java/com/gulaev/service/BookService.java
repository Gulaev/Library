package com.gulaev.service;

import com.gulaev.book.BookItem;
import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import com.gulaev.exception.DescriptionToLowException;
import com.gulaev.exception.PriceCantByZeroException;
import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookService {

  private final static Logger LOGGER = LogManager.getLogger(BookService.class);

    public static BookItem createNewBookItem(String author, String description, String title,
        Integer price, Genre genre, List<Tag> tags) {

      BookItem book = new BookItem();
      try {
        Random r = new Random();
         book = BookItem.builder().setId(r.nextInt())
            .setAuthor(author).setGenre(genre)
            .setPrice(price).setTitle(title)
            .addTag(tags).setDescription(description)
            .build();
        return book;

      } catch (DescriptionToLowException | PriceCantByZeroException e) {
        LOGGER.error(e.getMessage());
        return book;
      }
    }
}
