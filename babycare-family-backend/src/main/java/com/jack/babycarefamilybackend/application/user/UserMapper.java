package com.jack.babycarefamilybackend.application.user;

import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroupRepository;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.dto.user.CreateUserRequest;
import com.jack.babycarefamilybackend.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final FamilyGroupRepository familyGroupRepository;

    public User toEntity(CreateUserRequest request) {
        FamilyGroup group = familyGroupRepository.findById(request.familyGroupId())
                .orElseThrow(() -> new IllegalArgumentException("FamilyGroup not found"));
        return new User(request.nickname(), group);
    }

    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getNickname(), user.getFamilyGroup().getId());
    }
}
