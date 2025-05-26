package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.GrowthRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.GrowthRecordDto;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-26T13:42:44+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class GrowthRecordMapperImpl implements GrowthRecordMapper {

    @Override
    public GrowthRecordDto toDto(GrowthRecord growthRecord) {
        if ( growthRecord == null ) {
            return null;
        }

        Long babyId = null;
        Long userId = null;
        Long id = null;
        Double height = null;
        Double weight = null;
        Double headCircumference = null;
        LocalDateTime recordedAt = null;
        String note = null;

        babyId = growthRecordBabyId( growthRecord );
        userId = growthRecordUserId( growthRecord );
        id = growthRecord.getId();
        height = growthRecord.getHeight();
        weight = growthRecord.getWeight();
        headCircumference = growthRecord.getHeadCircumference();
        recordedAt = growthRecord.getRecordedAt();
        note = growthRecord.getNote();

        GrowthRecordDto growthRecordDto = new GrowthRecordDto( id, babyId, userId, height, weight, headCircumference, recordedAt, note );

        return growthRecordDto;
    }

    private Long growthRecordBabyId(GrowthRecord growthRecord) {
        if ( growthRecord == null ) {
            return null;
        }
        Baby baby = growthRecord.getBaby();
        if ( baby == null ) {
            return null;
        }
        Long id = baby.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long growthRecordUserId(GrowthRecord growthRecord) {
        if ( growthRecord == null ) {
            return null;
        }
        User user = growthRecord.getUser();
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
