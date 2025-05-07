package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.MedicalRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.dto.record.dto.MedicalRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateMedicalRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MedicalRecordMapper {


    @Mapping(target = "baby", source = "baby")
    @Mapping(target = "user", source = "user")
    MedicalRecord toEntity(CreateMedicalRecordRequest request, Baby baby, User user);

    @Mapping(source = "baby.id", target = "babyId")
    @Mapping(source = "user.id", target = "userId")
    MedicalRecordDto toDto(MedicalRecord record);
}
