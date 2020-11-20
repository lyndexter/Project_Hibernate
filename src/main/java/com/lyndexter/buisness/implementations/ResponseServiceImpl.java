package com.lyndexter.buisness.implementations;

import com.lyndexter.buisness.ResponseService;
import com.lyndexter.dao.CommonDao;
import com.lyndexter.dao.implementations.ResponseDaoImpl;
import com.lyndexter.model.Response;

public class ResponseServiceImpl implements ResponseService {

  CommonDao<Response, Integer> entityDao;

  @Override
  public CommonDao<Response, Integer> giveDaoObject() {
    if (entityDao == null) {
      entityDao = new ResponseDaoImpl();
    }
    return entityDao;
  }
}
