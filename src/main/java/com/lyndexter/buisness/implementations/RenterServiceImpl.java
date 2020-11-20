package com.lyndexter.buisness.implementations;

import com.lyndexter.buisness.RenterService;
import com.lyndexter.dao.CommonDao;
import com.lyndexter.dao.implementations.RenterDaoImpl;
import com.lyndexter.model.Renter;

public class RenterServiceImpl implements RenterService {

  private CommonDao<Renter, Integer> entityDao;

  @Override
  public CommonDao<Renter, Integer> giveDaoObject() {
    if (entityDao == null) {
      entityDao = new RenterDaoImpl();
    }
    return entityDao;
  }
}
