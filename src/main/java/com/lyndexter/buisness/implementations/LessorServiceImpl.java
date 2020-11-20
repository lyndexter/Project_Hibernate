package com.lyndexter.buisness.implementations;

import com.lyndexter.buisness.LessorService;
import com.lyndexter.dao.CommonDao;
import com.lyndexter.dao.implementations.LessorDaoImpl;
import com.lyndexter.model.Lessor;

public class LessorServiceImpl implements LessorService {

  private CommonDao<Lessor, Integer> entityDao;

  @Override
  public CommonDao<Lessor, Integer> giveDaoObject() {
    if (entityDao == null) {
      entityDao = new LessorDaoImpl();
    }
    return entityDao;
  }
}
