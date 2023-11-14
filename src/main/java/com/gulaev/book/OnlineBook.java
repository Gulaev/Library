package com.gulaev.book;

import com.gulaev.enums.Genre;
import com.gulaev.enums.Tag;
import com.gulaev.user.LibraryUser;
import com.gulaev.user.User;
import java.util.List;

public class OnlineBook implements Book, Purchasable{

  private Integer id;
  private String title;
  private String author;
  private String description;
  private Integer price;
  private List<Tag> tags;
  private Genre genre;

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
  public User removeFromCart(LibraryUser user) {
    return null;
  }
}
