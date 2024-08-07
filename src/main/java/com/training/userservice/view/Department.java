package com.training.userservice.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Department {
  private Long id;
  private String name;
  private String email;

  public Department(Long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public Department() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Department{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            '}';
  }
}
