package com.lyndexter.view;

import com.lyndexter.controller.ApartamentController;
import com.lyndexter.controller.ApartamentReservedController;
import com.lyndexter.controller.LessorController;
import com.lyndexter.controller.PaymentTransactionController;
import com.lyndexter.controller.PhotoController;
import com.lyndexter.controller.RenterController;
import com.lyndexter.controller.ResponseController;
import com.lyndexter.controller.imlementations.ApartamentControllerImpl;
import com.lyndexter.controller.imlementations.ApartamentReservedControllerImpl;
import com.lyndexter.controller.imlementations.LessorControllerImpl;
import com.lyndexter.controller.imlementations.PaymentTransactionControllerImpl;
import com.lyndexter.controller.imlementations.PhotoControllerImpl;
import com.lyndexter.controller.imlementations.RenterControllerImpl;
import com.lyndexter.controller.imlementations.ResponseControllerImpl;
import com.lyndexter.managers.SessionManager;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

  private final Map<String, String> menu;
  private final Map<String, Printable> methodsMenu;
  private final Scanner input;

  private final PhotoController photoController;
  private final LessorController lessorController;
  private final ApartamentController apartamentController;
  private final RenterController renterController;
  private final PaymentTransactionController transactionController;
  private final ApartamentReservedController apartamentReservedController;
  private final ResponseController responseController;

  public View() throws SQLException {

    input = new Scanner(System.in, StandardCharsets.UTF_8);

    photoController = new PhotoControllerImpl(input);
    lessorController = new LessorControllerImpl(input);
    apartamentController = new ApartamentControllerImpl(input);
    renterController = new RenterControllerImpl(input);
    transactionController = new PaymentTransactionControllerImpl(input);
    apartamentReservedController = new ApartamentReservedControllerImpl(input);
    responseController = new ResponseControllerImpl(input);

    menu = new LinkedHashMap<>();
    methodsMenu = new LinkedHashMap<>();

    menu.put("A", "A-Select all table");

    methodsMenu.put("A", this::printAllTables);

    // Menu for Photo
    menu.put("1", "1-Table:Photo");
    menu.put("11", "11-Find all photos");
    menu.put("12", "12-Find photo by id");
    menu.put("13", "13-Create photo");
    menu.put("14", "14-Update photo");
    menu.put("15", "15-Delete photo");

    methodsMenu.put("11", photoController::getEntities);
    methodsMenu.put("12", photoController::getEntity);
    methodsMenu.put("13", photoController::setEntity);
    methodsMenu.put("14", photoController::putEntity);
    methodsMenu.put("15", photoController::removeEntity);

    // Menu for Lessor
    menu.put("2", "2-Table:Lessor");
    menu.put("21", "21-Find all lessors");
    menu.put("22", "22-Find lessor by id");
    menu.put("23", "23-Create lessor");
    menu.put("24", "24-Update lessor");
    menu.put("25", "25-Delete lessor");

    methodsMenu.put("21", lessorController::getEntities);
    methodsMenu.put("22", lessorController::getEntity);
    methodsMenu.put("23", lessorController::setEntity);
    methodsMenu.put("24", lessorController::putEntity);
    methodsMenu.put("25", lessorController::removeEntity);

    // Menu for Apartament
    menu.put("3", "3-Table:Apartament");
    menu.put("31", "31-Find all apartaments");
    menu.put("32", "32-Find apartament by id");
    menu.put("33", "33-Create apartament");
    menu.put("34", "34-Update apartament");
    menu.put("35", "35-Delete apartament");

    methodsMenu.put("31", apartamentController::getEntities);
    methodsMenu.put("32", apartamentController::getEntity);
    methodsMenu.put("33", apartamentController::setEntity);
    methodsMenu.put("34", apartamentController::putEntity);
    methodsMenu.put("35", apartamentController::removeEntity);

    // Menu for Renter
    menu.put("4", "4-Table:Renter");
    menu.put("41", "41-Find all renters");
    menu.put("42", "42-Find renter by id");
    menu.put("43", "43-Create renter");
    menu.put("44", "44-Update renter");
    menu.put("45", "45-Delete renter");

    methodsMenu.put("41", renterController::getEntities);
    methodsMenu.put("42", renterController::getEntity);
    methodsMenu.put("43", renterController::setEntity);
    methodsMenu.put("44", renterController::putEntity);
    methodsMenu.put("45", renterController::removeEntity);

    // Menu for Response
    menu.put("5", "5-Table:Response");
    menu.put("51", "51-Find all responses");
    menu.put("52", "52-Find response by id");
    menu.put("53", "53-Create response");
    menu.put("54", "54-Update response");
    menu.put("55", "55-Delete response");

    methodsMenu.put("51", responseController::getEntities);
    methodsMenu.put("52", responseController::getEntity);
    methodsMenu.put("53", responseController::setEntity);
    methodsMenu.put("54", responseController::putEntity);
    methodsMenu.put("55", responseController::removeEntity);

    // Menu for PaymentTransaction
    menu.put("6", "6-Table:PaymentTransaction");
    menu.put("61", "61-Find all paymentTransactions");
    menu.put("62", "62-Find paymentTransaction by id");
    menu.put("63", "63-Create paymentTransaction");
    menu.put("64", "64-Update paymentTransaction");
    menu.put("65", "65-Delete paymentTransaction");

    methodsMenu.put("61", transactionController::getEntities);
    methodsMenu.put("62", transactionController::getEntity);
    methodsMenu.put("63", transactionController::setEntity);
    methodsMenu.put("64", transactionController::putEntity);
    methodsMenu.put("65", transactionController::removeEntity);

    // Menu for ApartamentReserved
    menu.put("7", "7-Table:ApartamentReserved");
    menu.put("71", "71-Find all apartamentReserveds");
    menu.put("72", "72-Find apartamentReserved by id");
    menu.put("73", "73-Create apartamentReserved");
    menu.put("74", "74-Update apartamentReserved");
    menu.put("75", "75-Delete apartamentReserved");

    methodsMenu.put("71", apartamentReservedController::getEntities);
    methodsMenu.put("72", apartamentReservedController::getEntity);
    methodsMenu.put("73", apartamentReservedController::setEntity);
    methodsMenu.put("74", apartamentReservedController::putEntity);
    methodsMenu.put("75", apartamentReservedController::removeEntity);

    menu.put("L", "L-go back");
    menu.put("Q", "Q-exit");
  }

  private void printAllTables() throws SQLException {
    photoController.getEntities();
    lessorController.getEntities();
    apartamentController.getEntities();
    renterController.getEntities();
    responseController.getEntities();
    transactionController.getEntities();
    apartamentReservedController.getEntities();
  }

  public void show() {

    String keyMenu;

    do {
      printMenu();
      System.out.println("Please, select point:");
      keyMenu = input.nextLine().toUpperCase();
      while (keyMenu.equals("")) {
        keyMenu = input.nextLine().toUpperCase();
      }

      if (keyMenu.matches("(^\\d)")) {
        printSubMenu(keyMenu);
        System.out.println("Please select point of menu:");
        keyMenu = input.nextLine().toUpperCase();
        while (keyMenu.equals("")) {
          keyMenu = input.nextLine().toUpperCase();
        }
      }

      if (keyMenu.equals("L")) {
        continue;
      }
      if (keyMenu.equals("Q")) {
        SessionManager.closeSessionFactory();
        break;
      }

      try {
        methodsMenu.get(keyMenu).print();
      } catch (Exception throwables) {
        System.out.println("Can't execute command");
        System.out.println("Exception is " + throwables.getMessage());
      }

    } while (true);
  }

  private void printMenu() {
    System.out.print("\n\nMenu:\n");
    for (Map.Entry<String, String> item : menu.entrySet()) {
      if (item.getKey().length() == 1 && !item.getKey().equals("L")) {
        System.out.println(item.getValue());
      }
    }
  }

  private void printSubMenu(String fig) {
    System.out.println("\n\nSubMenu:\n");
    for (Map.Entry<String, String> item : menu.entrySet()) {
      if (item.getKey().length() != 1 && item.getKey().substring(0, 1).equals(fig)
          || item.getKey().equals("L")
          || item.getKey().equals("Q")) {
        System.out.println(item.getValue());
      }
    }
  }
}
