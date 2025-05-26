package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.VaccinationRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.VaccinationRecordDto;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-26T13:42:44+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class VaccinationRecordMapperImpl implements VaccinationRecordMapper {

    @Override
    public VaccinationRecordDto toDto(VaccinationRecord record) {
        if ( record == null ) {
            return null;
        }

        Long babyId = null;
        Long userId = null;
        Long id = null;
        String vaccineName = null;
        LocalDateTime vaccinationDate = null;
        LocalDateTime nextVaccinationDate = null;
        String note = null;

        babyId = recordBabyId( record );
        userId = recordUserId( record );
        id = record.getId();
        vaccineName = record.getVaccineName();
        vaccinationDate = record.getVaccinationDate();
        nextVaccinationDate = record.getNextVaccinationDate();
        note = record.getNote();

        VaccinationRecordDto vaccinationRecordDto = new VaccinationRecordDto( id, babyId, userId, vaccineName, vaccinationDate, nextVaccinationDate, note );

        return vaccinationRecordDto;
    }

    private Long recordBabyId(VaccinationRecord vaccinationRecord) {
        if ( vaccinationRecord == null ) {
            return null;
        }
        Baby baby = vaccinationRecord.getBaby();
        if ( baby == null ) {
            return null;
        }
        Long id = baby.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long recordUserId(VaccinationRecord vaccinationRecord) {
        if ( vaccinationRecord == null ) {
            return null;
        }
        User user = vaccinationRecord.getUser();
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
