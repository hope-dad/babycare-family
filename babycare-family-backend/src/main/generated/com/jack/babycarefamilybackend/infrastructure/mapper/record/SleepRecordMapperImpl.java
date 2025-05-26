package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.SleepRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.SleepRecordDto;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-26T16:22:22+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class SleepRecordMapperImpl implements SleepRecordMapper {

    @Override
    public SleepRecordDto toDto(SleepRecord sleepRecord) {
        if ( sleepRecord == null ) {
            return null;
        }

        Long babyId = null;
        Long userId = null;
        Long id = null;
        LocalDateTime sleepStart = null;
        LocalDateTime sleepEnd = null;
        String note = null;

        babyId = sleepRecordBabyId( sleepRecord );
        userId = sleepRecordUserId( sleepRecord );
        id = sleepRecord.getId();
        sleepStart = sleepRecord.getSleepStart();
        sleepEnd = sleepRecord.getSleepEnd();
        note = sleepRecord.getNote();

        SleepRecordDto sleepRecordDto = new SleepRecordDto( id, babyId, userId, sleepStart, sleepEnd, note );

        return sleepRecordDto;
    }

    private Long sleepRecordBabyId(SleepRecord sleepRecord) {
        if ( sleepRecord == null ) {
            return null;
        }
        Baby baby = sleepRecord.getBaby();
        if ( baby == null ) {
            return null;
        }
        Long id = baby.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long sleepRecordUserId(SleepRecord sleepRecord) {
        if ( sleepRecord == null ) {
            return null;
        }
        User user = sleepRecord.getUser();
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
