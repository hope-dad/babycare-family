package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.MedicalRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.MedicalRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateMedicalRecordRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicalRecordMapper {


    MedicalRecord toEntity(CreateMedicalRecordRequest request, Baby baby, User user);

    MedicalRecordDto toDto(MedicalRecord record);
}
