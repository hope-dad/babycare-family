package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.MilestoneRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.MilestoneRecordDto;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-26T13:42:44+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class MilestoneRecordMapperImpl implements MilestoneRecordMapper {

    @Override
    public MilestoneRecordDto toDto(MilestoneRecord record) {
        if ( record == null ) {
            return null;
        }

        Long babyId = null;
        Long userId = null;
        Long id = null;
        String eventName = null;
        LocalDate date = null;
        String note = null;
        String photoUrl = null;

        babyId = recordBabyId( record );
        userId = recordUserId( record );
        id = record.getId();
        eventName = record.getEventName();
        date = record.getDate();
        note = record.getNote();
        photoUrl = record.getPhotoUrl();

        MilestoneRecordDto milestoneRecordDto = new MilestoneRecordDto( id, babyId, userId, eventName, date, note, photoUrl );

        return milestoneRecordDto;
    }

    private Long recordBabyId(MilestoneRecord milestoneRecord) {
        if ( milestoneRecord == null ) {
            return null;
        }
        Baby baby = milestoneRecord.getBaby();
        if ( baby == null ) {
            return null;
        }
        Long id = baby.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long recordUserId(MilestoneRecord milestoneRecord) {
        if ( milestoneRecord == null ) {
            return null;
        }
        User user = milestoneRecord.getUser();
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
