package com.training.userservice.service;

import com.training.userservice.entities.User;
import com.training.userservice.view.ResponseTemplateView;

public interface UserService {
  User saveUser(User user);

  User findById(Long id);

  ResponseTemplateView findByDepartmentId(Long id);
}
