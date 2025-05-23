package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.IllnessRecord;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.IllnessRecordDto;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-23T09:41:44+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class IllnessRecordMapperImpl implements IllnessRecordMapper {

    @Override
    public IllnessRecordDto toDto(IllnessRecord record) {
        if ( record == null ) {
            return null;
        }

        Long babyId = null;
        Long id = null;
        String symptom = null;
        LocalDate startDate = null;
        LocalDate endDate = null;
        String note = null;

        babyId = recordBabyId( record );
        id = record.getId();
        symptom = record.getSymptom();
        startDate = record.getStartDate();
        endDate = record.getEndDate();
        note = record.getNote();

        IllnessRecordDto illnessRecordDto = new IllnessRecordDto( id, babyId, symptom, startDate, endDate, note );

        return illnessRecordDto;
    }

    private Long recordBabyId(IllnessRecord illnessRecord) {
        if ( illnessRecord == null ) {
            return null;
        }
        Baby baby = illnessRecord.getBaby();
        if ( baby == null ) {
            return null;
        }
        Long id = baby.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
