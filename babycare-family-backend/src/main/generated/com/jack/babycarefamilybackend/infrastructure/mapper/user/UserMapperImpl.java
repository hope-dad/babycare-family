package com.jack.babycarefamilybackend.infrastructure.mapper.user;

import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRole;
import com.jack.babycarefamilybackend.infrastructure.web.dto.user.UserDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-26T13:42:44+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        Long familyGroupId = null;
        Long id = null;
        String name = null;
        String email = null;
        UserRole role = null;

        familyGroupId = userFamilyGroupId( user );
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        role = user.getRole();

        UserDto userDto = new UserDto( id, name, email, role, familyGroupId );

        return userDto;
    }

    private Long userFamilyGroupId(User user) {
        if ( user == null ) {
            return null;
        }
        FamilyGroup familyGroup = user.getFamilyGroup();
        if ( familyGroup == null ) {
            return null;
        }
        Long id = familyGroup.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
