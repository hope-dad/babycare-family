package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.GrowthRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.GrowthRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateGrowthRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface GrowthRecordMapper {

    default GrowthRecord toEntity(CreateGrowthRecordRequest request, Baby baby, User user) {
        return GrowthRecord.create(
                baby,
                user,
                request.height(),
                request.weight(),
                request.headCircumference(),
                request.recordedAt(),
                request.note()
        );
    }

    @Mappings({
            @org.mapstruct.Mapping(target = "babyId", source = "baby.id"),
            @org.mapstruct.Mapping(target = "userId", source = "user.id")
    })
    GrowthRecordDto toDto(GrowthRecord growthRecord);
}