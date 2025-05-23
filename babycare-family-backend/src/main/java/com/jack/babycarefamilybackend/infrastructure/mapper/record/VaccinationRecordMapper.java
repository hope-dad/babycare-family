package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.VaccinationRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.VaccinationRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateVaccinationRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface VaccinationRecordMapper {


    default VaccinationRecord toEntity(CreateVaccinationRecordRequest request, Baby baby, User user) {
        return VaccinationRecord.create(
                baby,
                user,
                request.vaccineName(),
                request.vaccinationDate(),
                request.nextVaccinationDate(),
                request.note()
        );
    }
    @Mappings({
            @org.mapstruct.Mapping(target = "babyId", source = "baby.id"),
            @org.mapstruct.Mapping(target = "userId", source = "user.id")
    })
    VaccinationRecordDto toDto(VaccinationRecord record);
}
