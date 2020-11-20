package com.lyndexter.buisness;

import com.lyndexter.dao.CommonDao;
import java.sql.SQLException;
import java.util.List;

public interface CommonService<T, ID> {

  CommonDao<T, ID> giveDaoObject();

  default List<T> findAll() throws SQLException {
    return giveDaoObject().findAll();
  }

  default T findById(ID id) throws SQLException {
    return giveDaoObject().findById(id);
  }

  default int create(T entity) throws SQLException {
    return giveDaoObject().create(entity);
  }

  default void update(T entity) throws SQLException {
    giveDaoObject().update(entity);
  }

  default int delete(ID id) throws SQLException {
    return giveDaoObject().delete(id);
  }
}
