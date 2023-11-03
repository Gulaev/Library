package com.gulaev.book;

import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import java.util.List;
import java.util.Objects;

public class Book {

  private Integer id;
  private String title;
  private String author;
  private String description;
  private Integer price;
  private List<Tag> tags;
  private Genre genre;



  public Book(Integer id, String title, String author, String description, Integer price,
      List<Tag> tags, Genre genre) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.description = description;
    this.price = price;
    this.tags = tags;
    this.genre = genre;
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
    Book book = (Book) o;
    return Objects.equals(id, book.id) && Objects.equals(title, book.title)
        && Objects.equals(author, book.author) && Objects.equals(description,
        book.description) && Objects.equals(price, book.price) && Objects.equals(
        tags, book.tags) && genre == book.genre;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, author, description, price, tags, genre);
  }
}
