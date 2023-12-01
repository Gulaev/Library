package com.gulaev.enums;

public enum Warehouses {

  LONDON("Unit 10, London Gateway Business Park, London SE28 9NR"),
  KYIV("Khreshchatyk Street, 10/12, Kyiv, 01001, Ukraine"),
  RYGA("Skanstes iela 50, Riga, LV-1013, Latvia"),
  NEW_YORK("100 Park Avenue, New York, NY 10017, USA"),
  PARIS("12 Avenue des Champs-Élysées, 75008 Paris, France"),
  TOKYO("1-10-10 Shibuya, Shibuya-ku, Tokyo, 150-0001, Japan"),
  SEOUL("123 Samsung-dong, Gangnam-gu, Seoul, 06018, South Korea"),
  SYDNEY("100 Barangaroo Avenue, Barangaroo, NSW 2000, Australia"),
  HONG_KONG("1 IFC, 8 Finance Street, Central, Hong Kong, China"),
  MUMBAI(
      "19th Floor, JMD Regent Towers, Bandra Kurla Complex, Bandra (East), Mumbai, Maharashtra 400051, India");

  private String address;

  private Warehouses(String address) {
    this.address = address;
  }

  public String getAddress() {
    return address;
  }
}