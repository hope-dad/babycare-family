package com.jack.babycarefamilybackend.application.schedule;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.BabyRepository;
import com.jack.babycarefamilybackend.domain.schedule.Schedule;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import com.jack.babycarefamilybackend.dto.schedule.CreateScheduleRequest;
import com.jack.babycarefamilybackend.dto.schedule.ScheduleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduleMapper {



    public Schedule toEntity(CreateScheduleRequest request, Baby baby, User user) {


        return new Schedule(
                baby,
                user,
                request.title(),
                request.startTime(),
                request.endTime(),
                request.description()
        );
    }

    public ScheduleDto toDto(Schedule schedule) {
        return new ScheduleDto(
                schedule.getId(),
                schedule.getBaby().getId(),
                schedule.getUser().getId(),
                schedule.getTitle(),
                schedule.getStartTime(),
                schedule.getEndTime(),
                schedule.getDescription(),
                schedule.getCreatedAt()
        );
    }
}
