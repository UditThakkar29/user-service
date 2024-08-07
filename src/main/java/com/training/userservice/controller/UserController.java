package com.training.userservice.controller;

import com.training.userservice.entities.User;
import com.training.userservice.service.UserService;
import com.training.userservice.view.ResponseTemplateView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
@CrossOrigin
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/")
  public User saveUser(@RequestBody User user) {
    User userRes = userService.saveUser(user);
    return userRes;
  }

  @GetMapping("/{id}")
  public User findUserById(@PathVariable("id") Long userId) {
    User user = userService.findById(userId);
    return user;
  }

  @GetMapping("/user/{userId}")
  public ResponseTemplateView getUserByDepartmentId(@PathVariable("userId") Long id) {
    ResponseTemplateView response = userService.findByDepartmentId(id);
    return response;
  }
}
