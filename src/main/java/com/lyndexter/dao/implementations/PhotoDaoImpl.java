package com.lyndexter.dao.implementations;

import com.lyndexter.dao.PhotoDao;
import com.lyndexter.dao.queries.QueryGenerator;

public class PhotoDaoImpl implements PhotoDao {

  private QueryGenerator queryGenerator;

  @Override
  public QueryGenerator getQueryGenerator() {
    if (queryGenerator == null) {
      queryGenerator = new QueryGenerator("Photo");
    }
    return queryGenerator;
  }
}
