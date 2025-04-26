package com.jack.babycarefamilybackend.domain.repository;

import com.jack.babycarefamilybackend.domain.model.User;
import java.util.Optional;

public interface UserRepository {

  Optional<User> findById(Long id);
  Optional<User> findByEmail(String email);
  User save(User user);
  void delete(Long id);

}
