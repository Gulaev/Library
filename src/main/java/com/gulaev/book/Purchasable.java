package com.gulaev.book;

import com.gulaev.user.LibraryUser;
import com.gulaev.user.User;

public interface Purchasable {

  User addToCart(LibraryUser user);

  User removeFromCart(LibraryUser user);
}
