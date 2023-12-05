package com.gulaev.builders;

import com.gulaev.book.BookItem;
import com.gulaev.enums.Genre;
import com.gulaev.enums.Stores;
import com.gulaev.enums.Tag;
import com.gulaev.enums.Warehouses;
import com.gulaev.exception.DescriptionToLowException;
import com.gulaev.exception.PriceCannotBeZeroException;
import com.gulaev.interfaces.function.Builder;
import java.util.ArrayList;
import java.util.List;

public class BookItemBuilder implements Builder<BookItem> {

    private Integer id;
    private String title;
    private String author;
    private String description;
    private Integer price;
    private List<Tag> tags;
    private Genre genre;
    private Warehouses warehouseLocation;
    private Stores storeLocation;

    public BookItemBuilder() {
      tags = new ArrayList<>();
    }

    public BookItemBuilder setId(Integer id) {
      this.id = id;
      return this;
    }

    public BookItemBuilder setTitle(String title) {
      this.title = title;
      return this;
    }

    public BookItemBuilder setAuthor(String author) {
      this.author = author;
      return this;
    }

    public BookItemBuilder setDescription(String description) throws DescriptionToLowException {
      if (description.length() < 50) {
        throw new DescriptionToLowException("Description cannot be less than 50 characters");
      }
      this.description = description;
      return this;
    }

    public BookItemBuilder setPrice(Integer price) throws PriceCannotBeZeroException {
      if (price <= 0) {
        throw new PriceCannotBeZeroException("The price cannot be less than 1 dollar");
      }
      this.price = price;
      return this;
    }

    public BookItemBuilder addTag(List<Tag> tags) {
      this.tags = tags;
      return this;
    }

    public BookItemBuilder setGenre(Genre genre) {
      this.genre = genre;
      return this;
    }

    public BookItemBuilder setWarehouseLocation(Warehouses warehouseLocation) {
      this.warehouseLocation = warehouseLocation;
      return this;
    }

    public BookItemBuilder setStoreLocation(Stores storeLocation) {
      this.storeLocation = storeLocation;
      return this;
    }

    public BookItem build() {
      return new BookItem(id, title, author, description, price, tags, genre, warehouseLocation, storeLocation);
    }
  }

