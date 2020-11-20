package com.lyndexter.buisness.implementations;

import com.lyndexter.buisness.ApartamentReservedService;
import com.lyndexter.dao.CommonDao;
import com.lyndexter.dao.implementations.ApartamentReservedDaoImpl;
import com.lyndexter.model.ApartamentReserved;

public class ApartamentReservedServiceImpl implements ApartamentReservedService {

  private CommonDao<ApartamentReserved, Integer> entityDao;

  @Override
  public CommonDao<ApartamentReserved, Integer> giveDaoObject() {
    if (entityDao == null) {
      entityDao = new ApartamentReservedDaoImpl();
    }
    return entityDao;
  }
}
