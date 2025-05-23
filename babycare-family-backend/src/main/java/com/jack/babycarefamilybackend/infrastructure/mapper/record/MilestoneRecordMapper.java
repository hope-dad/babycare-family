package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.MilestoneRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.MilestoneRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateMilestoneRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface MilestoneRecordMapper {

    default MilestoneRecord toEntity(CreateMilestoneRecordRequest request, Baby baby, User user) {
        return MilestoneRecord.create(
                baby,
                user,
                request.eventName(),
                request.date(),
                request.note(),
                request.photoUrl()
        );
    }

    @Mappings({
            @Mapping(target = "babyId", source = "baby.id"),
            @Mapping(target = "userId", source = "user.id")
    })
    MilestoneRecordDto toDto(MilestoneRecord record);
}
