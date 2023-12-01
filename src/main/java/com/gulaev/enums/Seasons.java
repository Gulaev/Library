package com.gulaev.enums;

public enum Seasons {

  SPRING(1, "Spring"),
  SUMMER(2, "Summer"),
  AUTUMN(3, "Autumn"),
  WINTER(4, "Winter");

  private final int seasonNumber;
  private final String seasonName;

  private Seasons(int seasonNumber, String seasonName) {
    this.seasonNumber = seasonNumber;
    this.seasonName = seasonName;
  }

  public int getSeasonNumber() {
    return seasonNumber;
  }

  public String getSeasonName() {
    return seasonName;
  }
}