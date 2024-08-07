package com.training.userservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NotNull
  private String firstName;
  private String lastName;
  @Email
  private String email;
  @NotNull
  private Long departmentId;

  public User() {

  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", departmentId=" + departmentId +
            '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public @NotNull String getFirstName() {
    return firstName;
  }

  public void setFirstName(@NotNull String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public @Email String getEmail() {
    return email;
  }

  public void setEmail(@Email String email) {
    this.email = email;
  }

  public @NotNull Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(@NotNull Long departmentId) {
    this.departmentId = departmentId;
  }

  public User(Long id, String firstName, String lastName, String email, Long departmentId) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.departmentId = departmentId;
  }
}
