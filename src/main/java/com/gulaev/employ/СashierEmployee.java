package com.gulaev.employ;

import com.gulaev.user.User;

public class СashierEmployee extends User implements Employee {

  private static final Integer SALARY_BY_DAY = 80;

  @Override
  public Integer calculateSalary(int dayOfWork) {
    return SALARY_BY_DAY * dayOfWork;
  }
}
