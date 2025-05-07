package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.IllnessRecord;
import com.jack.babycarefamilybackend.dto.record.dto.IllnessRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateIllnessRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IllnessRecordMapper {


    @Mapping(target = "baby", source = "baby")
    IllnessRecord toEntity(CreateIllnessRecordRequest request, Baby baby);


    @Mapping(source = "baby.id", target = "babyId")
    IllnessRecordDto toDto(IllnessRecord record);
}