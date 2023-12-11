package com.gulaev.enums;

import com.gulaev.interfaces.function.Calculator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public enum Genre {

  FICTION("Fiction literature"),
  MYSTERY("Mystery and secrets"),
  ROMANCE("Love Love"),
  SCIENCE_FICTION("Science"),
  FANTASY("Elden ring"),
  THRILLER("Thriller literature"),
  HORROR("Horror literature"),
  NON_FICTION("Non fiction literature"),
  BIOGRAPHY("Biography literature"),
  HISTORY("History literature");

  private String description;

//  {
//    System.out.println("Initialization " + this.description);
//  }


  Genre(String description) {
    this.description = description;
  }
}