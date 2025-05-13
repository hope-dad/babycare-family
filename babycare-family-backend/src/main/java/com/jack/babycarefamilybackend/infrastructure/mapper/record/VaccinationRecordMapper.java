package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.VaccinationRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.VaccinationRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateVaccinationRecordRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VaccinationRecordMapper {

    VaccinationRecord toEntity(CreateVaccinationRecordRequest request, Baby baby, User user);

    VaccinationRecordDto toDto(VaccinationRecord record);
}
