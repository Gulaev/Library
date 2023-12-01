package com.gulaev.enums;

public enum Stores {

  LONDON("Waterstones Piccadilly, 101-103 Piccadilly, London W1J 0DJ"),
  KYIV("Bookworm, 22 Khreshchatyk Street, Kyiv, 01001, Ukraine"),
  RYGA("Janis Roze Bookstores, Skanstes iela 50, Riga, LV-1013, Latvia"),
  NEW_YORK("Barnes & Noble, 721 Broadway, New York, NY 10003, USA"),
  PARIS("Librairie Shakespeare, 33 Rue de Beaune, 75007 Paris, France"),
  TOKYO("Tsutaya Books, 1-20-15 Shibuya-ku, Tokyo, 150-0001, Japan"),
  SEOUL("Kyobo Book Centre, Gwanghwamun Store, 191 Jongno-gu, Seoul, 03000, South Korea"),
  SYDNEY("Dymocks, 438 George Street, Sydney, NSW 2000, Australia"),
  HONG_KONG("PageOne, 1 IFC, 8 Finance Street, Central, Hong Kong, China"),
  MUMBAI(
      "Landmark, 19th Floor, JMD Regent Towers, Bandra Kurla Complex, Bandra (East), Mumbai, Maharashtra 400051, India");

  private String address;

  private Stores(String address) {
    this.address = address;
  }

  public String getAddress() {
    return address;
  }
}