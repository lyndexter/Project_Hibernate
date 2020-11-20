package com.lyndexter.controller.imlementations;

import com.lyndexter.buisness.CommonService;
import com.lyndexter.buisness.implementations.ApartamentServiceImpl;
import com.lyndexter.buisness.implementations.LessorServiceImpl;
import com.lyndexter.controller.ApartamentController;
import com.lyndexter.model.Apartament;
import java.sql.SQLException;
import java.util.Scanner;

public class ApartamentControllerImpl implements ApartamentController {

  private final Scanner input;

  public ApartamentControllerImpl(Scanner input) {
    this.input = input;
  }

  @Override
  public CommonService<Apartament, Integer> getService() {
    return new ApartamentServiceImpl();
  }

  @Override
  public void printHeaders() {
    Apartament.printHeaders();
  }

  @Override
  public Apartament inputEntity() throws SQLException {
    Apartament apartament = new Apartament();

    System.out.println("Please write adress:");
    apartament.setAdress(input.nextLine());

    System.out.println("\nPlease write area of apartament:");
    apartament.setArea(input.nextDouble());

    System.out.println("Please write ceiling high:");
    apartament.setCeilingHigh(input.nextDouble());

    System.out.println("Please write room number:");
    apartament.setRoomNumber(input.nextInt());

    System.out.println("Please write recomend people number:");
    apartament.setRecomendedPeopleCount(input.nextInt());

    System.out.println("Please write price:");
    apartament.setPrice(input.nextBigDecimal());

    System.out.println("Please write lessor id:");
    Integer inputLessorId = input.nextInt();
    apartament.setLessor(new LessorServiceImpl().findById(inputLessorId));

    return apartament;
  }

  @Override
  public Integer getId() {

    System.out.println("\nPlease write id of Apartament:");
    return input.nextInt();
  }
}
