package com.jack.babycarefamilybackend.application.user;

import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.dto.user.CreateUserRequest;
import com.jack.babycarefamilybackend.dto.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "familyGroup", source = "familyGroup")
    User toEntity(CreateUserRequest request, FamilyGroup familyGroup);

    @Mapping(source = "familyGroup.id", target = "familyGroupId")
    UserDto toDto(User user);
}
