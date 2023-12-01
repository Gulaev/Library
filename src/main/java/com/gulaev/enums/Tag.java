package com.gulaev.enums;

public enum Tag {

  WAR(100),
  HISTORY(95),
  SCHOOL_LIFE(65),
  HEALTHY_FOOD(79),
  GYM(80),
  ROMANCE(90),
  MYSTERY(88),
  SCIENCE_FICTION(76),
  FANTASY(53),
  THRILLER(14),
  HORROR(2342),
  NON_FICTION(234),
  BIOGRAPHY(232),
  COMEDY(2342),
  ADVENTURE(343),
  TRAVEL(234),
  SELF_HELP(588),
  COOKING(775),
  TECHNOLOGY(53),
  PHILOSOPHY(52),
  POETRY(523),
  MUSIC(35),
  ART(35),
  POLITICS(35),
  BUSINESS(84),
  ENVIRONMENT(53),
  SPORTS(53),
  RELIGION(75),
  PSYCHOLOGY(573),
  DRAMA(75);

  private Integer count;

  private Tag(Integer count) {
    this.count = count;
  }

  public Integer getCount() {
    return count;
  }
}