package com.gulaev.book;

import com.gulaev.builders.OnlineBookBuilder;
import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import com.gulaev.interfaces.Book;
import com.gulaev.interfaces.Purchasable;
import com.gulaev.user.LibraryUser;
import com.gulaev.user.User;
import java.io.File;
import java.util.List;
import java.util.Objects;

public class OnlineBook implements Book, Purchasable {

  private Integer id;
  private String title;
  private String author;
  private String description;
  private Integer price;
  private List<Tag> tags;
  private Genre genre;
  private File cover;

  public OnlineBook(Integer id, String title, String author, String description, Integer price,
      List<Tag> tags, Genre genre, File cover) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.description = description;
    this.price = price;
    this.tags = tags;
    this.genre = genre;
    this.cover = cover;
  }

  @Override
  public Integer getPriceWithDiscount(LibraryUser user) {
    if (user.getDiscountCount() != null && this.price != null) {
      int discountAmount = (this.price * user.getDiscountCount()) / 100;
      return price - discountAmount;
    }
    return null;
  }

  @Override
  public User addToCart(LibraryUser user) {
    List<Book> bag = user.getBag();
    bag.add(this);
    user.setBag(bag);
    return user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OnlineBook that = (OnlineBook) o;
    return Objects.equals(id, that.id) && Objects.equals(title, that.title)
        && Objects.equals(author, that.author) && Objects.equals(description,
        that.description) && Objects.equals(price, that.price) && Objects.equals(
        tags, that.tags) && genre == that.genre;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, author, description, price, tags, genre);
  }

  public Integer getId() {
    return id;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPrice() {
    return price;
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

  @Override
  public String getTitle() {
    return this.title;
  }

  @Override
  public String getAuthor() {
    return this.author;
  }

  @Override
  public List<Tag> getTags() {
    return this.tags;
  }

  @Override
  public Genre getGenre() {
    return this.genre;
  }


  @Override
  public User removeFromCart(LibraryUser user) {
    return null;
  }


  public static OnlineBookBuilder builder() {
    return new OnlineBookBuilder();
  }

  @Override
  public String toString() {
    return "OnlineBook{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", description='" + description + '\'' +
        ", price=" + price +
        ", tags=" + tags +
        ", genre=" + genre +
        ", cover=" + cover.toString() +
        '}';
  }
}
