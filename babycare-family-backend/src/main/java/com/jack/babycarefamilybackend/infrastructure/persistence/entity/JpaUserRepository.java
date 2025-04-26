package com.jack.babycarefamilybackend.infrastructure.persistence.entity;

import com.jack.babycarefamilybackend.domain.model.User;
import com.jack.babycarefamilybackend.domain.repository.UserRepository;
import com.jack.babycarefamilybackend.infrastructure.persistence.jpa.JpaUserSpringDataRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserRepository implements UserRepository {

  private final JpaUserSpringDataRepository springDataRepository;

  public JpaUserRepository(JpaUserSpringDataRepository springDataRepository) {
    this.springDataRepository = springDataRepository;
  }

  @Override
  public Optional<User> findById(Long id) {
    return springDataRepository.findById(id).map(this::toDomain);
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return springDataRepository.findByEmail(email).map(this::toDomain);
  }

  @Override
  public User save(User user) {
    UserEntity entity = toEntity(user);
    UserEntity saved = springDataRepository.save(entity);
    return toDomain(saved);
  }

  @Override
  public void delete(Long id) {
    springDataRepository.deleteById(id);
  }

  private User toDomain(UserEntity entity) {
    return User.builder()
        .id(entity.getId())
        .email(entity.getEmail())
        .name(entity.getName())
        .password(entity.getPassword())
        .profileImageUrl(entity.getProfileImageUrl())
        .familyGroupId(entity.getFamilyGroupId())
        .role(entity.getRole())
        .provider(entity.getProvider())
        .providerId(entity.getProviderId())
        .build();
  }

  private UserEntity toEntity(User user) {
    return UserEntity.builder()
        .id(user.getId())
        .email(user.getEmail())
        .name(user.getName())
        .password(user.getPassword())
        .profileImageUrl(user.getProfileImageUrl())
        .familyGroupId(user.getFamilyGroupId())
        .role(user.getRole())
        .provider(user.getProvider())
        .providerId(user.getProviderId())
        .build();
  }
}
