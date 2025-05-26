package com.jack.babycarefamilybackend.application.usecase.user;

import com.jack.babycarefamilybackend.infrastructure.web.dto.user.CreateUserRequest;
import com.jack.babycarefamilybackend.infrastructure.web.dto.user.UserDto;

import java.util.List;

public interface UserService {


    UserDto createUser(CreateUserRequest request);

    List<UserDto> getUsersByFamilyGroup(Long familyGroupId);

    UserDto getUserById(Long userId);
}