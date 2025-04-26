package com.jack.babycarefamilybackend.infrastructure.persistence.jpa;

import com.jack.babycarefamilybackend.infrastructure.persistence.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserSpringDataRepository extends JpaRepository<UserEntity, Long> {
  Optional<UserEntity> findByEmail(String email);
}
