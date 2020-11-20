package com.lyndexter.controller.imlementations;

import com.lyndexter.buisness.CommonService;
import com.lyndexter.controller.ResponseController;
import com.lyndexter.dao.implementations.ResponseDaoImpl;
import com.lyndexter.model.Response;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class ResponseControllerImpl implements ResponseController {

  private final Scanner input;

  public ResponseControllerImpl(Scanner input) {
    this.input = input;
  }

  @Override
  public CommonService<Response, Integer> getService() {
    return ResponseDaoImpl::new;
  }

  @Override
  public void printHeaders() {
    Response.printHeaders();
  }

  @Override
  public Response inputEntity() throws SQLException, IOException {
    Response response = new Response();

    System.out.println("\nPlease write comment:");
    response.setComent(input.nextLine());

    System.out.println("Please write rate:");
    response.setRate(input.nextInt());

    return response;
  }

  @Override
  public Integer getId() {
    System.out.println("\nPlease write id of Response:");
    return input.nextInt();
  }
}
