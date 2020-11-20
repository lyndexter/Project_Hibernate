package com.lyndexter.dao.implementations;

import com.lyndexter.dao.ResponseDao;
import com.lyndexter.dao.queries.QueryGenerator;

public class ResponseDaoImpl implements ResponseDao {

  private QueryGenerator queryGenerator;

  @Override
  public QueryGenerator getQueryGenerator() {
    if (queryGenerator == null) {
      queryGenerator = new QueryGenerator("Response");
    }
    return queryGenerator;
  }
}
