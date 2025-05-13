package com.jack.babycarefamilybackend.infrastructure.mapper.schedule;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.schedule.Schedule;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.schedule.CreateScheduleRequest;
import com.jack.babycarefamilybackend.infrastructure.web.dto.schedule.ScheduleDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ScheduleMapper {


    Schedule toEntity(CreateScheduleRequest request, Baby baby, User user);

    ScheduleDto toDto(Schedule schedule);
}
