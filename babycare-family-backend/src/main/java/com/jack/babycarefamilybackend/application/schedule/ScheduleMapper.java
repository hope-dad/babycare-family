package com.jack.babycarefamilybackend.application.schedule;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.schedule.Schedule;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.dto.schedule.CreateScheduleRequest;
import com.jack.babycarefamilybackend.dto.schedule.ScheduleDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ScheduleMapper {


    @Mapping(target = "baby", source = "baby")
    @Mapping(target = "user", source = "user")
    Schedule toEntity(CreateScheduleRequest request, Baby baby, User user);

    @Mapping(source = "baby.id", target = "babyId")
    @Mapping(source = "user.id", target = "userId")
    ScheduleDto toDto(Schedule schedule);
}
