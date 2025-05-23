package com.jack.babycarefamilybackend.infrastructure.mapper.schedule;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.schedule.Schedule;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.schedule.CreateScheduleRequest;
import com.jack.babycarefamilybackend.infrastructure.web.dto.schedule.ScheduleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface ScheduleMapper {


    default Schedule toEntity(CreateScheduleRequest request, Baby baby, User user) {
        return Schedule.create(
                baby,
                user,
                request.title(),
                request.startTime(),
                request.endTime(),
                request.description()
        );
    }

    @Mappings({
            @org.mapstruct.Mapping(target = "babyId", source = "baby.id"),
            @org.mapstruct.Mapping(target = "userId", source = "user.id")
    })
    ScheduleDto toDto(Schedule schedule);
}
