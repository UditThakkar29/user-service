package com.training.userservice.view;

import com.training.userservice.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateView {
  private User user;
  private Department department;


  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
