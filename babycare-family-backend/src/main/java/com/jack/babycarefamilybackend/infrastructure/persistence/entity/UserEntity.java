package com.jack.babycarefamilybackend.infrastructure.persistence.entity;

import com.jack.babycarefamilybackend.domain.model.User;
import com.jack.babycarefamilybackend.domain.model.enums.Provider;
import com.jack.babycarefamilybackend.domain.model.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String name;

  private String password;

  private String profileImageUrl;

  private Long familyGroupId;

  @Enumerated(EnumType.STRING)
  private Role role;

  @Enumerated(EnumType.STRING)
  private Provider provider;

  private String providerId;

  // 도메인 모델 변환 메서드
  public User toDomain() {
    return User.builder()
        .id(this.id)
        .email(this.email)
        .name(this.name)
        .password(this.password)
        .profileImageUrl(this.profileImageUrl)
        .familyGroupId(this.familyGroupId)
        .role(this.role)
        .provider(this.provider)
        .providerId(this.providerId)
        .build();
  }

  // 도메인 모델에서 엔티티로 변환
  public static UserEntity fromDomain(User user) {
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
