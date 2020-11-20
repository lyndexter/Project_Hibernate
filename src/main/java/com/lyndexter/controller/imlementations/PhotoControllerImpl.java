package com.lyndexter.controller.imlementations;

import com.lyndexter.buisness.CommonService;
import com.lyndexter.controller.PhotoController;
import com.lyndexter.dao.implementations.PhotoDaoImpl;
import com.lyndexter.model.Photo;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.Scanner;

public class PhotoControllerImpl implements PhotoController {

  private static final String DEFAULT_PATH_IMAGE = "src\\main\\resources\\sample.png";

  private final Scanner input;

  public PhotoControllerImpl(Scanner input) {
    this.input = input;
  }

  @Override
  public CommonService<Photo, Integer> getService() {
    return PhotoDaoImpl::new;
  }

  @Override
  public void printHeaders() {
    Photo.printHeaders();
  }

  @Override
  public Photo inputEntity() throws SQLException, IOException {
    Photo photo = new Photo();
    System.out.println("\nPlease write type of photo:");
    photo.setType(input.nextLine());

    System.out.println("Insert image path:");
    String inputPath = input.nextLine();
    byte[] inputImage;
    try {
      File fi = new File(inputPath);
      inputImage = Files.readAllBytes(fi.toPath());
      photo.setImage(inputImage);
    } catch (IOException e) {
      System.out.println("Your path is invalid: insert default value");
      File fi = new File(DEFAULT_PATH_IMAGE);
      inputImage = Files.readAllBytes(fi.toPath());
      photo.setImage(inputImage);
    }

    System.out.println("Write image size:");
    photo.setImageSize(input.nextLine());

    System.out.println("Write name of photo:");
    photo.setName(input.nextLine());

    return photo;
  }

  @Override
  public Integer getId() {
    System.out.println("\nPlease type id of element:");
    return Integer.parseInt(input.nextLine());
  }
}
