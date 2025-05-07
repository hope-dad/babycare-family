package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.GrowthRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.dto.record.dto.GrowthRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateGrowthRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GrowthRecordMapper {



    @Mapping(target = "baby", source = "baby")
    @Mapping(target = "user", source = "user")
    GrowthRecord toEntity(CreateGrowthRecordRequest request, Baby baby, User user);

    @Mapping(source = "baby.id", target = "babyId")
    @Mapping(source = "user.id", target = "userId")
    GrowthRecordDto toDto(GrowthRecord growthRecord);
}