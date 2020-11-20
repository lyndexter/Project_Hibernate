package com.lyndexter.buisness.implementations;

import com.lyndexter.buisness.PaymentTransactionService;
import com.lyndexter.dao.CommonDao;
import com.lyndexter.dao.implementations.PaymentTreansactionDaoImpl;
import com.lyndexter.model.PaymentTransaction;

public class PaymentTransactionServiceImpl implements PaymentTransactionService {

  CommonDao<PaymentTransaction, Integer> entityDao;

  @Override
  public CommonDao<PaymentTransaction, Integer> giveDaoObject() {
    if (entityDao == null) {
      entityDao = new PaymentTreansactionDaoImpl();
    }
    return entityDao;
  }
}
