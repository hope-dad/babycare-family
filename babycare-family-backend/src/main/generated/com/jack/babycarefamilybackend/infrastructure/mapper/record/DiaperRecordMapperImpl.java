package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.DiaperRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.DiaperRecordDto;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-26T16:22:22+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class DiaperRecordMapperImpl implements DiaperRecordMapper {

    @Override
    public DiaperRecordDto toDto(DiaperRecord diaperRecord) {
        if ( diaperRecord == null ) {
            return null;
        }

        Long babyId = null;
        Long userId = null;
        Long id = null;
        String type = null;
        String note = null;
        LocalDateTime changedAt = null;

        babyId = diaperRecordBabyId( diaperRecord );
        userId = diaperRecordUserId( diaperRecord );
        id = diaperRecord.getId();
        if ( diaperRecord.getType() != null ) {
            type = diaperRecord.getType().name();
        }
        note = diaperRecord.getNote();
        changedAt = diaperRecord.getChangedAt();

        DiaperRecordDto diaperRecordDto = new DiaperRecordDto( id, babyId, userId, type, note, changedAt );

        return diaperRecordDto;
    }

    private Long diaperRecordBabyId(DiaperRecord diaperRecord) {
        if ( diaperRecord == null ) {
            return null;
        }
        Baby baby = diaperRecord.getBaby();
        if ( baby == null ) {
            return null;
        }
        Long id = baby.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long diaperRecordUserId(DiaperRecord diaperRecord) {
        if ( diaperRecord == null ) {
            return null;
        }
        User user = diaperRecord.getUser();
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
