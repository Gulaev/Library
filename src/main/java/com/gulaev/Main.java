package com.gulaev;

import com.gulaev.book.Book;
import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import com.gulaev.repository.BookRepository;
import com.gulaev.service.BookRecommendationService;
import com.gulaev.user.LibraryUser;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    // Create new books
    Book book1 = new Book(1, "Title1", "Nick", "Description1", 10,
        Arrays.asList(Tag.WAR, Tag.COMEDY), Genre.FANTASY);
    Book book2 = new Book(2, "Title2", "John", "Description2", 20,
        Arrays.asList(Tag.HISTORY, Tag.WAR), Genre.MYSTERY);
    Book book3 = new Book(3, "Title3", "Nick", "Description3", 30,
        Arrays.asList(Tag.COMEDY, Tag.HISTORY), Genre.MYSTERY);

    // Create a new user with a wishlist and bought books
    LibraryUser user = new LibraryUser();
    user.setWantish(Arrays.asList(book1, book2));
    user.setBoughtBooks(Arrays.asList(book3));

    // Get book recommendations for the user
    Set<Book> recommendedBooks = BookRecommendationService.findBookByPreferences(user);

    // Print the recommended books
    recommendedBooks.forEach(System.out::println);
  }

}