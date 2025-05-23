package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.MedicalRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.MedicalRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateMedicalRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MedicalRecordMapper {


    default MedicalRecord toEntity(CreateMedicalRecordRequest request, Baby baby, User user) {
        return MedicalRecord.create(
                baby,
                user,
                request.diagnosis(),
                request.treatment(),
                request.prescribedMedication(),
                request.visitDate(),
                request.doctorName(),
                request.note()
        );
    }
    @Mappings({
            @Mapping(target = "babyId", source = "baby.id"),
            @Mapping(target = "userId", source = "user.id")
    })
    MedicalRecordDto toDto(MedicalRecord record);
}
