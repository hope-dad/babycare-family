package com.jack.babycarefamilybackend.infrastructure.mapper.user;

import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.user.CreateUserRequest;
import com.jack.babycarefamilybackend.infrastructure.web.dto.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {


    default User toEntity(CreateUserRequest request, FamilyGroup familyGroup) {
        return new User(
                request.name(),
                request.email(),
                request.role(),
                familyGroup
        );
    }

    // User 엔티티를 받아서 UserDto로 변환
    @Mappings({
            @Mapping(target = "familyGroupId", source = "user.familyGroup.id")
    })
    UserDto toDto(User user);

}