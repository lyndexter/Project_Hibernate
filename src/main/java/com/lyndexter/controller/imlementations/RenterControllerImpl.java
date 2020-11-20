package com.lyndexter.controller.imlementations;

import com.lyndexter.buisness.CommonService;
import com.lyndexter.buisness.implementations.PhotoServiceImpl;
import com.lyndexter.controller.RenterController;
import com.lyndexter.dao.implementations.RenterDaoImpl;
import com.lyndexter.model.Renter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class RenterControllerImpl implements RenterController {

  private final Scanner input;

  public RenterControllerImpl(Scanner input) {
    this.input = input;
  }

  @Override
  public CommonService<Renter, Integer> getService() {
    return RenterDaoImpl::new;
  }

  @Override
  public void printHeaders() {
    Renter.printHeaders();
  }

  @Override
  public Renter inputEntity() throws SQLException, IOException {
    Renter renter = new Renter();
    System.out.println("\nPlease write name of renter:");
    renter.setName(input.nextLine());

    System.out.println("Please write surname:");
    renter.setSurname(input.nextLine());

    System.out.println("Please write last name:");
    renter.setLastName(input.nextLine());

    System.out.println("Please write phone number:");
    renter.setPhoneNumber(input.nextLine());

    System.out.println("Please write card number:");
    renter.setCardNumber(input.nextLine());

    System.out.println("Please write photo id:");
    final int inputPhotoId = input.nextInt();
    renter.setPhoto(new PhotoServiceImpl().findById(inputPhotoId));

    return renter;
  }

  @Override
  public Integer getId() {
    System.out.println("\nPlease write id of Renter:");
    return input.nextInt();
  }
  
  @Override
  public Renter getId(Renter entity) {
    System.out.println("\nPlease write id of Renter:");
    entity.setId( input.nextInt());
    return entity;
  }
}
