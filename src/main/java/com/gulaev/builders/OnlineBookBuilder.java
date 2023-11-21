package com.gulaev.builders;

import com.gulaev.book.OnlineBook;
import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import com.gulaev.interfaces.Builder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OnlineBookBuilder implements Builder<OnlineBook> {

  public final static Logger LOGGER = LogManager.getLogger(OnlineBookBuilder.class);

  private final String STANDARD_IMAGE_PATH = "/Users/denisgulaev/Documents/projects/Java Automation Task/Library/src/main/resources/cover/img.png";
  private Integer id;
  private String title;
  private String author;
  private String description;
  private Integer price;
  private List<Tag> tags;
  private Genre genre;
  private File cover;

  public OnlineBookBuilder() {
  }

  public OnlineBookBuilder setId(Integer id) {
    this.id = id;
    return this;
  }

  public OnlineBookBuilder setTitle(String title) {
    this.title = title;
    return this;
  }

  public OnlineBookBuilder setAuthor(String author) {
    this.author = author;
    return this;
  }

  public OnlineBookBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public OnlineBookBuilder setPrice(Integer price) {
    this.price = price;
    return this;
  }

  public OnlineBookBuilder setTags(List<Tag> tags) {
    this.tags = tags;
    return this;
  }

  public OnlineBookBuilder setGenre(Genre genre) {
    this.genre = genre;
    return this;
  }

  public OnlineBookBuilder setCover(String filePath) {
    LOGGER.info("Start setCover");
    try (FileInputStream fis = new FileInputStream(filePath)) {
      File file = new File(fis.toString());
      this.cover = file;

    } catch (FileNotFoundException e) {
      LOGGER.error("File with photo not found, set standard image");
      File file = new File(STANDARD_IMAGE_PATH);
      this.cover = file;

    } catch (IOException e) {
      LOGGER.error(e.getMessage());
    }

    LOGGER.info("Method setCover executed");
    return this;
  }


  public OnlineBook build() {
    return new OnlineBook(id, title, author, description, price, tags, genre, cover);
  }
}
