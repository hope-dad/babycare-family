package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.VaccinationRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.dto.record.dto.VaccinationRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateVaccinationRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VaccinationRecordMapper {

    @Mapping(target = "baby", source = "baby")
    @Mapping(target = "user", source = "user")
    VaccinationRecord toEntity(CreateVaccinationRecordRequest request, Baby baby, User user);

    @Mapping(source = "baby.id", target = "babyId")
    @Mapping(source = "user.id", target = "userId")
    VaccinationRecordDto toDto(VaccinationRecord record);
}
