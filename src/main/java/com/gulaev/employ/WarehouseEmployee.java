package com.gulaev.employ;

import com.gulaev.interfaces.Employee;
import com.gulaev.user.User;

public class WarehouseEmployee extends User implements Employee {

  private static final Integer SALARY_BY_DAY = 100;

  @Override
  public Integer calculateSalary(int dayOfWork) {
    return SALARY_BY_DAY * dayOfWork;
  }
}
