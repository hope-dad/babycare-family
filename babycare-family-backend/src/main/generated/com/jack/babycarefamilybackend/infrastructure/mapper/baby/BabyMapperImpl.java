package com.jack.babycarefamilybackend.infrastructure.mapper.baby;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.infrastructure.web.dto.baby.BabyDto;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-23T09:41:44+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class BabyMapperImpl implements BabyMapper {

    @Override
    public BabyDto toDto(Baby baby) {
        if ( baby == null ) {
            return null;
        }

        Long familyGroupId = null;
        Long id = null;
        String name = null;
        LocalDate birthDate = null;
        String gender = null;
        String photoUrl = null;
        String bloodType = null;
        String characteristics = null;
        String allergies = null;
        String prenatalName = null;

        familyGroupId = babyFamilyGroupId( baby );
        id = baby.getId();
        name = baby.getName();
        birthDate = baby.getBirthDate();
        gender = baby.getGender();
        photoUrl = baby.getPhotoUrl();
        bloodType = baby.getBloodType();
        characteristics = baby.getCharacteristics();
        allergies = baby.getAllergies();
        prenatalName = baby.getPrenatalName();

        BabyDto babyDto = new BabyDto( id, name, birthDate, gender, familyGroupId, photoUrl, bloodType, characteristics, allergies, prenatalName );

        return babyDto;
    }

    private Long babyFamilyGroupId(Baby baby) {
        if ( baby == null ) {
            return null;
        }
        FamilyGroup familyGroup = baby.getFamilyGroup();
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
