package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.HospitalVisitRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.HospitalVisitRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateHospitalVisitRecordRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HospitalVisitRecordMapper {


    HospitalVisitRecord toEntity(CreateHospitalVisitRecordRequest request, Baby baby, User user);

    HospitalVisitRecordDto toDto(HospitalVisitRecord record);
}
