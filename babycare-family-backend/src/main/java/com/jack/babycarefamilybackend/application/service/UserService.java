package com.jack.babycarefamilybackend.application.service;

import com.jack.babycarefamilybackend.domain.model.User;
import com.jack.babycarefamilybackend.domain.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional(readOnly = true)
  public Optional<User> getUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Transactional
  public User createUser(User user) {
    // 추가 유스케이스 로직 가능
    return userRepository.save(user);
  }
}
