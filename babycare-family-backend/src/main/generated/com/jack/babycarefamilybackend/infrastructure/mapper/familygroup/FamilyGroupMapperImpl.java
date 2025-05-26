package com.jack.babycarefamilybackend.infrastructure.mapper.familygroup;

import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.infrastructure.web.dto.familygroup.CreateFamilyGroupRequest;
import com.jack.babycarefamilybackend.infrastructure.web.dto.familygroup.FamilyGroupDto;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-26T16:22:22+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class FamilyGroupMapperImpl implements FamilyGroupMapper {

    @Override
    public FamilyGroup toEntity(CreateFamilyGroupRequest request) {
        if ( request == null ) {
            return null;
        }

        String name = null;

        name = request.name();

        FamilyGroup familyGroup = new FamilyGroup( name );

        return familyGroup;
    }

    @Override
    public FamilyGroupDto toDto(FamilyGroup familyGroup) {
        if ( familyGroup == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        LocalDateTime createdAt = null;

        id = familyGroup.getId();
        name = familyGroup.getName();
        createdAt = familyGroup.getCreatedAt();

        FamilyGroupDto familyGroupDto = new FamilyGroupDto( id, name, createdAt );

        return familyGroupDto;
    }
}
