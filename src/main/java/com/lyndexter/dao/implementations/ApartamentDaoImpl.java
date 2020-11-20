package com.lyndexter.dao.implementations;

import com.lyndexter.dao.ApartamentDao;
import com.lyndexter.dao.queries.QueryGenerator;

public class ApartamentDaoImpl implements ApartamentDao {

  private QueryGenerator queryGenerator;

  @Override
  public QueryGenerator getQueryGenerator() {
    if (queryGenerator == null) {
      queryGenerator = new QueryGenerator("Apartament");
    }
    return queryGenerator;
  }
}
