package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.IllnessRecord;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.IllnessRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateIllnessRecordRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IllnessRecordMapper {


    IllnessRecord toEntity(CreateIllnessRecordRequest request, Baby baby);


    IllnessRecordDto toDto(IllnessRecord record);
}