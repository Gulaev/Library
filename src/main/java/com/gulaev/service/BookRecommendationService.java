package com.gulaev.service;

import com.gulaev.interfaces.Book;
import com.gulaev.book.BookItem;
import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import com.gulaev.repository.BookRepository;
import com.gulaev.user.LibraryUser;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookRecommendationService {

  private static final Logger LOGGER = LogManager.getLogger(BookRecommendationService.class);

  public static Set<BookItem> findBookByPreferences(LibraryUser user) {
    LOGGER.info("Start findBookByPreferences");
    List<Book> usersWishlist = user.getWishlist();
    List<Book> userBoughtBookItems = user.getBoughtBooks();
    Set<Book> bookItems = Stream.concat(usersWishlist.stream(), userBoughtBookItems.stream())
        .collect(Collectors.toSet());

    List<String> popularAuthorList = findPopularAuthors(bookItems, 2);
    List<Tag> tagsList = findPopularTags(bookItems, 3);
    List<Genre> genreList = findPopularGenres(bookItems, 2);

    List<BookItem> allBookItem = BookRepository.getAllBooks();

    List<BookItem> recommendedBooksOnAuthor = allBookItem.stream()
        .filter(book -> popularAuthorList.contains(book.getAuthor())).toList();

    List<BookItem> recommendedBooksOnTag = allBookItem.stream().
        filter(book -> book.getTags().stream().anyMatch(tagsList::contains)).toList();

    List<BookItem> recommendedBookOnGenreItem = allBookItem.stream()
        .filter(book -> genreList.contains(book.getGenre())).toList();

    Set<BookItem> recommendedBookItems =
        Stream.of(recommendedBooksOnAuthor, recommendedBooksOnTag, recommendedBookOnGenreItem)
            .flatMap(List::stream)
            .collect(Collectors.toSet());

    LOGGER.info("Method findBookByPreferences executed");
    return recommendedBookItems;
  }


  private static List<String> findPopularAuthors(Set<Book> bookItems, int threshold) {
    Map<String, Long> authorCounts = bookItems.stream()
        .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()));

    return authorCounts.entrySet().stream()
        .filter(entry -> entry.getValue() >= threshold)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }

  private static List<Tag> findPopularTags(Set<Book> bookItems, int threshold) {
    Map<Tag, Long> tagCounts = bookItems.stream()
        .flatMap(book -> book.getTags().stream())
        .collect(Collectors.groupingBy(tag -> tag, Collectors.counting()));

    return tagCounts.entrySet().stream()
        .filter(entry -> entry.getValue() >= threshold)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }

  private static List<Genre> findPopularGenres(Set<Book> bookItems, int threshold) {
    Map<Genre, Long> genreCounts = bookItems.stream()
        .collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()));

    return genreCounts.entrySet().stream()
        .filter(entry -> entry.getValue() >= threshold)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }
}
