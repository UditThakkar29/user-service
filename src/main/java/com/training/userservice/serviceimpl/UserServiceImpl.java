package com.training.userservice.serviceimpl;

import com.training.userservice.entities.User;
import com.training.userservice.repository.UserRepository;
import com.training.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
  private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired
  private UserRepository userRepository;

  @Override
  public User saveUser(User user) {
    User savedUser = userRepository.save(user);
    return savedUser;
  }
}
