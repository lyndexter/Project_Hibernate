package com.lyndexter.dao.implementations;

import com.lyndexter.dao.LessorDao;
import com.lyndexter.dao.queries.QueryGenerator;

public class LessorDaoImpl implements LessorDao {

  private QueryGenerator queryGenerator;

  @Override
  public QueryGenerator getQueryGenerator() {
    if (queryGenerator == null) {
      queryGenerator = new QueryGenerator("Lessor");
    }
    return queryGenerator;
  }
}
