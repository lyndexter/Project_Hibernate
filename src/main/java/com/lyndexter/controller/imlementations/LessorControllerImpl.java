package com.lyndexter.controller.imlementations;

import com.lyndexter.buisness.CommonService;
import com.lyndexter.buisness.implementations.PhotoServiceImpl;
import com.lyndexter.controller.LessorController;
import com.lyndexter.dao.implementations.LessorDaoImpl;
import com.lyndexter.model.Lessor;
import java.sql.SQLException;
import java.util.Scanner;

public class LessorControllerImpl implements LessorController {

  private final Scanner input;

  public LessorControllerImpl(Scanner input) {
    this.input = input;
  }

  @Override
  public CommonService<Lessor, Integer> getService() {
    return LessorDaoImpl::new;
  }

  @Override
  public void printHeaders() {
    Lessor.printHeaders();
  }

  @Override
  public Lessor inputEntity() throws SQLException {
    Lessor lessor = new Lessor();
    System.out.println("\nPlease write name of lessor:");
    lessor.setName(input.nextLine());

    System.out.println("Please write surname:");
    lessor.setSurname(input.nextLine());

    System.out.println("Please write last name:");
    lessor.setLastName(input.nextLine());

    System.out.println("Please write phone number:");
    lessor.setPhoneNumber(input.nextLine());

    System.out.println("Please write card number:");
    lessor.setCardNumber(input.nextLine());

    System.out.println("Please write contact info:");
    lessor.setContactInfo(input.nextLine());

    System.out.println("Please write photo id:");
    final int inputPhotoId = input.nextInt();
    lessor.setPhoto(new PhotoServiceImpl().findById(inputPhotoId));

    return lessor;
  }

  @Override
  public Integer getId() {
    System.out.println("\nPlease write id of lessor:");
    return input.nextInt();
  }

  @Override
  public Lessor getId(Lessor entity) {
    System.out.println("\nPlease write id of lessor:");
    entity.setId(input.nextInt());
    return entity;
  }
}
