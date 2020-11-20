package com.lyndexter.controller;

import com.lyndexter.buisness.CommonService;
import com.lyndexter.view.Printable;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CommonController<T, Id> {

  CommonService<T, Id> getService();

  void printHeaders();

  T inputEntity() throws SQLException, IOException;

  Id getId();

  T getId(T entity);

  default void getEntities() throws SQLException {

    List<T> entities = getService().findAll();
    printHeaders();
    for (T entity : entities) {
      System.out.println(entity);
    }
  }

  default Printable getEntity() throws SQLException {
    Id id = getId();
    T entity = getService().findById(id);
    printHeaders();
    System.out.println(entity);
    return null;
  }

  default void setEntity() throws SQLException, IOException {
    T entity = inputEntity();
    System.out.println(getService().create(entity));
  }

  default void putEntity() throws SQLException, IOException {
    T entity = inputEntity();
    T entityWithId = getId(entity);
    getService().update(entityWithId);
  }

  default int removeEntity() throws SQLException {
    Id id = getId();
    return getService().delete(id);
  }
}
