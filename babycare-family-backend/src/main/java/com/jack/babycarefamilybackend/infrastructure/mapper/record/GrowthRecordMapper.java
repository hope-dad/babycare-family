package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.GrowthRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.GrowthRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateGrowthRecordRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GrowthRecordMapper {


    GrowthRecord toEntity(CreateGrowthRecordRequest request, Baby baby, User user);

    GrowthRecordDto toDto(GrowthRecord growthRecord);
}