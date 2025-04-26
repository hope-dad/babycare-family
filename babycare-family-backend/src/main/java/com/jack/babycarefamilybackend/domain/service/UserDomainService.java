package com.jack.babycarefamilybackend.domain.service;

import com.jack.babycarefamilybackend.domain.model.User;
import com.jack.babycarefamilybackend.domain.repository.UserRepository;
import java.util.Optional;

public class UserDomainService {
  private final UserRepository userRepository;

  public UserDomainService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Optional<User> findUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public User registerUser(User user) {
    // 비즈니스 규칙 검증 가능
    return userRepository.save(user);
  }

  // 기타 도메인 관련 메서드 구현
}
