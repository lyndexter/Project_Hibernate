package com.lyndexter.dao.implementations;

import com.lyndexter.dao.PaymentTransactionDao;
import com.lyndexter.dao.queries.QueryGenerator;

public class PaymentTreansactionDaoImpl implements PaymentTransactionDao {

  private QueryGenerator queryGenerator;

  @Override
  public QueryGenerator getQueryGenerator() {
    if (queryGenerator == null) {
      queryGenerator = new QueryGenerator("PaymentTransaction");
    }
    return queryGenerator;
  }
}
