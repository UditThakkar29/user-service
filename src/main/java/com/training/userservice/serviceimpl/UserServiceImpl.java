package com.training.userservice.serviceimpl;

import com.training.userservice.entities.User;
import com.training.userservice.repository.UserRepository;
import com.training.userservice.service.UserService;
import com.training.userservice.view.Department;
import com.training.userservice.view.ResponseTemplateView;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
  private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

  Long fallbackUserId;
  int attempts = 1;


  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public User saveUser(User user) {
    User savedUser = userRepository.save(user);
    return savedUser;
  }

  @Override
  public User findById(Long id) {
    return userRepository.findById(id).get();
  }

  @Override
  @Retry(name = "userService", fallbackMethod = "fallback_findByDepartmentId")
  public ResponseTemplateView findByDepartmentId(Long id) {
    ResponseTemplateView view = new ResponseTemplateView();
    User user = userRepository.findById(id).get();
    LOGGER.info("Requesting attempt: {}", attempts++);
    fallbackUserId = id;
    LOGGER.info("connecting with department");
    Department department = restTemplate.getForObject("http://DEPARTMENT/department/" + user.getDepartmentId(), Department.class);
    LOGGER.info("department {}", department);
    view.setUser(user);
    view.setDepartment(department);
    LOGGER.info("connected with department{}", view);
    return view;
  }

  public ResponseTemplateView fallback_findByDepartmentId(Exception e) {
    LOGGER.info("fallback method called");
    attempts = 1;
    ResponseTemplateView view = new ResponseTemplateView();
    User user = userRepository.findById(fallbackUserId).get();
    view.setUser(user);
    return view;
  }
}
