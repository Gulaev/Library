package com.gulaev.employ;

import com.gulaev.user.User;

public class СashierEmploy extends User implements Employ {

  private static final Integer SALARY_BY_DAY = 80;

  @Override
  public Integer calculateSalary(int dayOfWork) {
    return SALARY_BY_DAY * dayOfWork;
  }
}
