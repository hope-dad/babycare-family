package com.jack.babycarefamilybackend.application.usecase.schedule;

import com.jack.babycarefamilybackend.infrastructure.web.dto.schedule.CreateScheduleRequest;
import com.jack.babycarefamilybackend.infrastructure.web.dto.schedule.ScheduleDto;

import java.util.List;

public interface ScheduleService {

    ScheduleDto createSchedule(CreateScheduleRequest request);

    List<ScheduleDto> getByBabyId(Long babyId);

    List<ScheduleDto> getByUserId(Long userId);
}