package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.HospitalVisitRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.HospitalVisitRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateHospitalVisitRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface HospitalVisitRecordMapper {

    default HospitalVisitRecord toEntity(CreateHospitalVisitRecordRequest request, Baby baby, User user) {
        return HospitalVisitRecord.create(
                baby,
                user,
                request.visitDate(),
                request.hospitalName(),
                request.symptoms(),
                request.diagnosis(),
                request.prescribedMedication()
        );
    }

    @Mappings({
            @Mapping(target = "babyId", source = "baby.id"),
            @Mapping(target = "userId", source = "user.id")
    })
    HospitalVisitRecordDto toDto(HospitalVisitRecord record);
}
