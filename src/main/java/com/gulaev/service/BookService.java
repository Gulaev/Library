package com.gulaev.service;

import com.gulaev.book.BookItem;
import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import com.gulaev.exception.DescriptionToLowException;
import com.gulaev.exception.PriceCannotBeZeroException;
import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookService {

  private final static Logger LOGGER = LogManager.getLogger(BookService.class);

    public static BookItem createNewBookItem(String author, String description, String title,
        Integer price, Genre genre, List<Tag> tags) {
      LOGGER.info("Start createNewBookItem");
      BookItem book = new BookItem();
      try {
        Random r = new Random();
         book = BookItem.builder().setId(r.nextInt())
            .setAuthor(author).setGenre(genre)
            .setPrice(price).setTitle(title)
            .addTag(tags).setDescription(description)
            .build();

      } catch (DescriptionToLowException | PriceCannotBeZeroException e) {
        LOGGER.error(e.getMessage());
      }

      LOGGER.info("Method createNewBookItem executed");
      return book;
    }
}
