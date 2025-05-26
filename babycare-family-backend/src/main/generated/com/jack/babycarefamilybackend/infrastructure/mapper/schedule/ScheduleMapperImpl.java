package com.jack.babycarefamilybackend.infrastructure.mapper.schedule;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.schedule.Schedule;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.schedule.ScheduleDto;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-26T16:22:22+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class ScheduleMapperImpl implements ScheduleMapper {

    @Override
    public ScheduleDto toDto(Schedule schedule) {
        if ( schedule == null ) {
            return null;
        }

        Long babyId = null;
        Long userId = null;
        Long id = null;
        String title = null;
        LocalDateTime startTime = null;
        LocalDateTime endTime = null;
        String description = null;
        LocalDateTime createdAt = null;

        babyId = scheduleBabyId( schedule );
        userId = scheduleUserId( schedule );
        id = schedule.getId();
        title = schedule.getTitle();
        startTime = schedule.getStartTime();
        endTime = schedule.getEndTime();
        description = schedule.getDescription();
        createdAt = schedule.getCreatedAt();

        ScheduleDto scheduleDto = new ScheduleDto( id, babyId, userId, title, startTime, endTime, description, createdAt );

        return scheduleDto;
    }

    private Long scheduleBabyId(Schedule schedule) {
        if ( schedule == null ) {
            return null;
        }
        Baby baby = schedule.getBaby();
        if ( baby == null ) {
            return null;
        }
        Long id = baby.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long scheduleUserId(Schedule schedule) {
        if ( schedule == null ) {
            return null;
        }
        User user = schedule.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
