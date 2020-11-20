package com.lyndexter.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.Set;

@Entity
public class Photo {
  private Integer id;
  private String type;
  private byte[] image;
  private String imageSize;
  private String name;
  private Set<Lessor> lessors;
  private Set<Renter> renters;
  private Set<Apartament> apartaments;
  private Set<Response> responses;

  public Photo() {}

  public Photo(Integer id, String type, byte[] image, String imageSize, String name) {
    this.id = id;
    this.type = type;
    this.image = image.clone();
    this.imageSize = imageSize;
    this.name = name;
  }

  public static void printHeaders() {
    System.out.format("%3s    %-12s %-10s %-20s %s%n", "id", "type", "imageSize", "name", "image");
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
  @Column(name = "type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Basic
  @Column(name = "image")
  public byte[] getImage() {
    return image.clone();
  }

  public void setImage(byte[] image) {
    this.image = image.clone();
  }

  @Basic
  @Column(name = "image_size")
  public String getImageSize() {
    return imageSize;
  }

  public void setImageSize(String imageSize) {
    this.imageSize = imageSize;
  }

  @Basic
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Photo photo = (Photo) o;

    if (id != null ? !id.equals(photo.id) : photo.id != null) {
      return false;
    }
    if (type != null ? !type.equals(photo.type) : photo.type != null) {
      return false;
    }
    if (!Arrays.equals(image, photo.image)) {
      return false;
    }
    if (imageSize != null ? !imageSize.equals(photo.imageSize) : photo.imageSize != null) {
      return false;
    }
    return name != null ? name.equals(photo.name) : photo.name == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (type != null ? type.hashCode() : 0);
    result = 31 * result + Arrays.hashCode(image);
    result = 31 * result + (imageSize != null ? imageSize.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

  @OneToMany(mappedBy = "photo")
  public Set<Lessor> getLessors() {
    return lessors;
  }

  public void setLessors(Set<Lessor> lessors) {
    this.lessors = lessors;
  }

  @OneToMany(mappedBy = "photo")
  public Set<Renter> getRenters() {
    return renters;
  }

  public void setRenters(Set<Renter> renters) {
    this.renters = renters;
  }

  @ManyToMany(mappedBy = "photos")
  public Set<Apartament> getApartaments() {
    return apartaments;
  }

  public void setApartaments(Set<Apartament> apartaments) {
    this.apartaments = apartaments;
  }

  @ManyToMany
  @JoinTable(
      name = "response_photo",
      joinColumns = @JoinColumn(name = "photo_id", referencedColumnName = "id", nullable = false),
      inverseJoinColumns =
          @JoinColumn(name = "response_id", referencedColumnName = "id", nullable = false))
  public Set<Response> getResponses() {
    return responses;
  }

  public void setResponses(Set<Response> responses) {
    this.responses = responses;
  }

  @Override
  public String toString() {
    return String.format(
        "%3s    %-12s %-10s %-20s %s%n", id, type, imageSize, name, Arrays.toString(image));
  }
}
