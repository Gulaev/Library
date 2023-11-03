package com.gulaev.service;

import com.gulaev.book.Book;
import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import com.gulaev.repository.BookRepository;
import com.gulaev.user.LibraryUser;
import com.gulaev.user.User;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookRecommendationService {

     public static Set<Book> findBookByPreferences(LibraryUser user) {
        List<Book> usersWishlist = user.getWantish();
        List<Book> userBoughtBooks = user.getBoughtBooks();
        Set<Book> books = Stream.concat(usersWishlist.stream(), userBoughtBooks.stream())
            .collect(Collectors.toSet());

        List<String> popularAuthorList = findPopularAuthors(books, 2);
        List<Tag> tagsList = findPopularTags(books, 3);
        List<Genre> genreList = findPopularGenres(books, 2);

        List<Book> allBook = BookRepository.getAllBooks();
        // Filter books from the repository based on the user's preferences

       List<Book> recommendedBooksOnAuthor = allBook.stream()
           .filter(book -> popularAuthorList.contains(book.getAuthor())).toList();

       List<Book> recommendedBooksOnTag = allBook.stream().
           filter(book -> book.getTags().stream().anyMatch(tagsList::contains)).toList();

       List<Book> recommendedBookOnGenre = allBook.stream()
           .filter(book -> genreList.contains(book.getGenre())).toList();

       Set<Book> recommendedBooks = Stream.of(recommendedBooksOnAuthor, recommendedBooksOnTag, recommendedBookOnGenre)
           .flatMap(List::stream)
           .collect(Collectors.toSet());


        return recommendedBooks;
    }



  private static List<String> findPopularAuthors(Set<Book> books, int threshold) {
    Map<String, Long> authorCounts = books.stream()
        .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()));

    return authorCounts.entrySet().stream()
        .filter(entry -> entry.getValue() >= threshold)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }

  private static List<Tag> findPopularTags(Set<Book> books, int threshold) {
    Map<Tag, Long> tagCounts = books.stream()
        .flatMap(book -> book.getTags().stream())
        .collect(Collectors.groupingBy(tag -> tag, Collectors.counting()));

    return tagCounts.entrySet().stream()
        .filter(entry -> entry.getValue() >= threshold)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }

  private static List<Genre> findPopularGenres(Set<Book> books, int threshold) {
    Map<Genre, Long> genreCounts = books.stream()
        .collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()));

    return genreCounts.entrySet().stream()
        .filter(entry -> entry.getValue() >= threshold)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }


}
