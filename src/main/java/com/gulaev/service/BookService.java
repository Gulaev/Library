package com.gulaev.service;

import com.gulaev.book.BookItem;
import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import com.gulaev.exception.DescriptionToLowException;
import com.gulaev.exception.PriceCantByZeroException;
import java.util.List;
import java.util.Random;

public class BookService {


    public static BookItem createNewBookItem(String author, String description, String title, Integer price,
        Genre genre, List<Tag> tags) {

      try {
        Random r = new Random();
        BookItem book = BookItem.builder().setId(r.nextInt())
            .setAuthor(author).setGenre(genre)
            .setPrice(price).setTitle(title)
            .addTag(tags).setDescription(description)
            .build();
        return book;

      } catch (DescriptionToLowException e) {
        return new BookItem();

      } catch (PriceCantByZeroException e) {
        return new BookItem();
      }

    }

}
