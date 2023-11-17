package com.gulaev.book;

import com.gulaev.builders.BookItemBuilder;
import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import com.gulaev.user.LibraryUser;
import com.gulaev.user.User;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookItem implements Book, Purchasable {

//  private static final Logger log = LogManager.getLogger(BookItem.class);

  private Integer id;
  private String title;
  private String author;
  private String description;
  private Integer price;
  private List<Tag> tags;
  private Genre genre;

  public BookItem(Integer id, String title, String author, String description, Integer price,
      List<Tag> tags, Genre genre) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.description = description;
    this.price = price;
    this.tags = tags;
    this.genre = genre;
  }

  @Override
  public User addToCart(LibraryUser user) {
    List<Book> bag = user.getBag();
    bag.add(this);
    user.setBag(bag);
    return user;
  }

  @Override
  public User removeFromCart(LibraryUser user) {
    List<Book> bag = user.getBag();
    Optional<Book> first = bag.stream()
        .filter(bookItem-> bookItem.getTitle().matches(this.title)).findFirst();
    if (first.isPresent()) {
      bag.remove(first.get());
      user.setBag(bag);
    } else {
//     log.error("Book is not present");
    }
    return user;
  }



  @Override
  public Integer getPriceWithDiscount(LibraryUser user) {
    if (user.getDiscountCount() != null && this.price != null) {
      int discountAmount = (this.price * user.getDiscountCount()) / 100;
      return price - discountAmount;
    }
    return null;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  public Integer getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getDescription() {
    return description;
  }

  public Integer getPrice() {
    return price;
  }

  public List<Tag> getTags() {
    return tags;
  }

  public Genre getGenre() {
    return genre;
  }
  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", description='" + description + '\'' +
        ", price=" + price +
        ", tags=" + tags +
        ", genre=" + genre +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookItem bookItem = (BookItem) o;
    return Objects.equals(id, bookItem.id) && Objects.equals(title, bookItem.title)
        && Objects.equals(author, bookItem.author) && Objects.equals(description,
        bookItem.description) && Objects.equals(price, bookItem.price) && Objects.equals(
        tags, bookItem.tags) && genre == bookItem.genre;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, author, description, price, tags, genre);
  }


  public static BookItemBuilder builder() {
    return new BookItemBuilder();
  }

}
