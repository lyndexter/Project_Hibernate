package com.lyndexter.controller.imlementations;

import com.lyndexter.buisness.CommonService;
import com.lyndexter.buisness.implementations.ApartamentServiceImpl;
import com.lyndexter.buisness.implementations.PaymentTransactionServiceImpl;
import com.lyndexter.controller.ApartamentReservedController;
import com.lyndexter.dao.implementations.ApartamentReservedDaoImpl;
import com.lyndexter.model.ApartamentReserved;
import java.sql.SQLException;
import java.util.Scanner;

public class ApartamentReservedControllerImpl implements ApartamentReservedController {

  private final Scanner input;

  public ApartamentReservedControllerImpl(Scanner input) {
    this.input = input;
  }

  @Override
  public CommonService<ApartamentReserved, Integer> getService() {
    return ApartamentReservedDaoImpl::new;
  }

  @Override
  public void printHeaders() {
    ApartamentReserved.printHeaders();
  }

  @Override
  public ApartamentReserved inputEntity() throws SQLException {
    ApartamentReserved apartamentReserved = new ApartamentReserved();

    System.out.println("\nPlease write apartament id:");
    Integer inputApartamentId = input.nextInt();
    apartamentReserved.setApartament(new ApartamentServiceImpl().findById(inputApartamentId));

    System.out.println("Please if it is reserved(true/false)");
    apartamentReserved.setReserved(input.nextByte());

    System.out.println("Please write payment transaction id:");
    Integer inputTransactionId = input.nextInt();
    apartamentReserved.setPaymentTransaction(
        new PaymentTransactionServiceImpl().findById(inputTransactionId));

    System.out.println("Please write wish to apartament:");
    apartamentReserved.setWish(input.nextLine());

    return apartamentReserved;
  }

  @Override
  public Integer getId() {
    System.out.println("\nPlease write id of ApartamentReserved:");
    return input.nextInt();
  }
}
