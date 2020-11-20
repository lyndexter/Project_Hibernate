package com.lyndexter.dao.implementations;

import com.lyndexter.dao.ApartamentReservedDao;
import com.lyndexter.dao.queries.QueryGenerator;

public class ApartamentReservedDaoImpl implements ApartamentReservedDao {

  private QueryGenerator queryGenerator;

  @Override
  public QueryGenerator getQueryGenerator() {
    if (queryGenerator == null) {
      queryGenerator = new QueryGenerator("ApartamentReserved");
    }
    return queryGenerator;
  }
}
