package com.example.savetravels.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "saves")
public class Save {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String expense;

  @NotNull
  private String vendor;

  @NotNull
  private Integer rating;

  @NotNull
  private String notes;

  // This will not allow the createdAt column to be updated after creation
  @Column(updatable = false)
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createdAt;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updatedAt;



  public Save() {
  }


  public Save(String expense, String vendor, Integer rating, String notes) {
    this.expense = expense;
    this.vendor = vendor;
    this.rating = rating;
    this.notes = notes;

  }


  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.expense;
  }

  public void setName(String expense) {
    this.expense = expense;
  }

  public String getRestaurantName() {
    return this.vendor;
  }

  public void setRestaurantName(String vendor) {
    this.vendor = vendor;
  }

  public Integer getRating() {
    return this.rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public String getNotes() {
    return this.notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }


}
