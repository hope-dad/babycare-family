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



    public User toEntity(CreateUserRequest request, FamilyGroup familyGroup) {


        return new User(
                request.name(),
                request.email(),
                request.role(),
                familyGroup
        );
    }

    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getFamilyGroup() != null ? user.getFamilyGroup().getId() : null
        );
    }
}
