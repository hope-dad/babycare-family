package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.IllnessRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.IllnessRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateIllnessRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IllnessRecordMapper {



    default IllnessRecord toEntity(CreateIllnessRecordRequest request, Baby baby) {
        return IllnessRecord.create(
                baby,
                request.symptom(),
                request.startDate(),
                request.endDate(),
                request.note()
        );
    }
    @Mappings({@Mapping(target = "babyId", source = "baby.id")})
    IllnessRecordDto toDto(IllnessRecord record);
}