package com.jack.babycarefamilybackend.domain.port.repository;

import com.jack.babycarefamilybackend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByFamilyGroupId(Long familyGroupId);
}
