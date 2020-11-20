package com.lyndexter.buisness.implementations;

import com.lyndexter.buisness.PhotoService;
import com.lyndexter.dao.CommonDao;
import com.lyndexter.dao.implementations.PhotoDaoImpl;
import com.lyndexter.model.Photo;

public class PhotoServiceImpl implements PhotoService {

  private CommonDao<Photo, Integer> entityDao;

  @Override
  public CommonDao<Photo, Integer> giveDaoObject() {
    if (entityDao == null) {
      entityDao = new PhotoDaoImpl();
    }
    return entityDao;
  }
}
