package com.lyndexter.controller.imlementations;

import com.lyndexter.buisness.CommonService;
import com.lyndexter.buisness.implementations.LessorServiceImpl;
import com.lyndexter.buisness.implementations.RenterServiceImpl;
import com.lyndexter.controller.PaymentTransactionController;
import com.lyndexter.dao.implementations.PaymentTreansactionDaoImpl;
import com.lyndexter.model.PaymentTransaction;
import java.sql.SQLException;
import java.util.Scanner;

public class PaymentTransactionControllerImpl implements PaymentTransactionController {

  private final Scanner input;

  public PaymentTransactionControllerImpl(Scanner input) {
    this.input = input;
  }

  @Override
  public CommonService<PaymentTransaction, Integer> getService() {
    return PaymentTreansactionDaoImpl::new;
  }

  @Override
  public void printHeaders() {
    PaymentTransaction.printHeaders();
  }

  @Override
  public PaymentTransaction inputEntity() throws SQLException {
    PaymentTransaction paymentTransaction = new PaymentTransaction();
    System.out.println("\nPlease write renter id:");
    final int inputRenterId = input.nextInt();
    paymentTransaction.setRenter(new RenterServiceImpl().findById(inputRenterId));

    System.out.println("Please write lessor id");
    final int inputLessorId = input.nextInt();
    paymentTransaction.setLessor(new LessorServiceImpl().findById(inputLessorId));

    System.out.println("Please write renter_payment(true/false):");
    paymentTransaction.setRenterPayment(input.nextByte());

    System.out.println("Please write lessor recieve money or not:");
    paymentTransaction.setLessorRecieveMoney(input.nextByte());

    return paymentTransaction;
  }

  @Override
  public Integer getId() {
    System.out.println("\nPlease write id of PaymentTransactions:");
    return input.nextInt();
  }

  @Override
  public PaymentTransaction getId(PaymentTransaction entity) {
    System.out.println("\nPlease write id of PaymentTransactions:");
    entity.setId(input.nextInt());
    return entity;
  }
}
