package com.jack.babycarefamilybackend.domain.model;

import com.jack.babycarefamilybackend.domain.model.enums.Provider;
import com.jack.babycarefamilybackend.domain.model.enums.Role;
import java.util.Objects;
import lombok.Builder;
import lombok.Getter;


@Getter
public class User {
  private final Long id;
  private final String email;
  private final String name;
  private final String password;
  private final String profileImageUrl;
  private final Long familyGroupId;
  private final Role role;
  private final Provider provider;
  private final String providerId;

  @Builder
  public User(Long id, String email, String name, String password, String profileImageUrl,
      Long familyGroupId, Role role, Provider provider, String providerId) {
    this.id = id;
    this.email = email;
    this.name = name;
    this.password = password;
    this.profileImageUrl = profileImageUrl;
    this.familyGroupId = familyGroupId;
    this.role = role;
    this.provider = provider;
    this.providerId = providerId;
  }

  public boolean isAdmin() {
    return this.role == Role.ADMIN;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
