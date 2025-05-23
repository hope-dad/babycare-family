package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.FeedingRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.FeedingRecordDto;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-23T09:41:44+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class FeedingRecordMapperImpl implements FeedingRecordMapper {

    @Override
    public FeedingRecordDto toDto(FeedingRecord feedingRecord) {
        if ( feedingRecord == null ) {
            return null;
        }

        Long babyId = null;
        Long userId = null;
        Long id = null;
        String type = null;
        Double amount = null;
        LocalDateTime fedAt = null;

        babyId = feedingRecordBabyId( feedingRecord );
        userId = feedingRecordUserId( feedingRecord );
        id = feedingRecord.getId();
        type = feedingRecord.getType();
        amount = feedingRecord.getAmount();
        fedAt = feedingRecord.getFedAt();

        FeedingRecordDto feedingRecordDto = new FeedingRecordDto( id, babyId, userId, type, amount, fedAt );

        return feedingRecordDto;
    }

    private Long feedingRecordBabyId(FeedingRecord feedingRecord) {
        if ( feedingRecord == null ) {
            return null;
        }
        Baby baby = feedingRecord.getBaby();
        if ( baby == null ) {
            return null;
        }
        Long id = baby.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long feedingRecordUserId(FeedingRecord feedingRecord) {
        if ( feedingRecord == null ) {
            return null;
        }
        User user = feedingRecord.getUser();
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
