package com.lyndexter.buisness.implementations;

import com.lyndexter.buisness.ApartamentService;
import com.lyndexter.dao.CommonDao;
import com.lyndexter.dao.implementations.ApartamentDaoImpl;
import com.lyndexter.model.Apartament;

public class ApartamentServiceImpl implements ApartamentService {

  private CommonDao<Apartament, Integer> entityDao;

  @Override
  public CommonDao<Apartament, Integer> giveDaoObject() {
    if (entityDao == null) {
      entityDao = new ApartamentDaoImpl();
    }
    return entityDao;
  }
}
