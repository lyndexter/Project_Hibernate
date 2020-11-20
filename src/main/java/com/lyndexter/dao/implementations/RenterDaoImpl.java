package com.lyndexter.dao.implementations;

import com.lyndexter.dao.RenterDao;
import com.lyndexter.dao.queries.QueryGenerator;

public class RenterDaoImpl implements RenterDao {

  private QueryGenerator queryGenerator;

  @Override
  public QueryGenerator getQueryGenerator() {
    if (queryGenerator == null) {
      queryGenerator = new QueryGenerator("Renter");
    }
    return queryGenerator;
  }
}
