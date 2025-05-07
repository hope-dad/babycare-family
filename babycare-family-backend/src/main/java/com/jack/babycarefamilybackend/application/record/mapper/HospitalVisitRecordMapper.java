package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.HospitalVisitRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.dto.record.dto.HospitalVisitRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateHospitalVisitRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HospitalVisitRecordMapper {


    @Mapping(target = "baby", source = "baby")
    @Mapping(target = "user", source = "user")
    HospitalVisitRecord toEntity(CreateHospitalVisitRecordRequest request, Baby baby, User user);

    @Mapping(source = "baby.id", target = "babyId")
    @Mapping(source = "user.id", target = "userId")
    HospitalVisitRecordDto toDto(HospitalVisitRecord record);
}
