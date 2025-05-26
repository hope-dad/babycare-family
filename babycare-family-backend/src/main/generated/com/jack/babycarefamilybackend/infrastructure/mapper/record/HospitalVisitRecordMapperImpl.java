package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.HospitalVisitRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.HospitalVisitRecordDto;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-26T13:42:44+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class HospitalVisitRecordMapperImpl implements HospitalVisitRecordMapper {

    @Override
    public HospitalVisitRecordDto toDto(HospitalVisitRecord record) {
        if ( record == null ) {
            return null;
        }

        Long babyId = null;
        Long userId = null;
        Long id = null;
        LocalDateTime visitDate = null;
        String hospitalName = null;
        String symptoms = null;
        String diagnosis = null;
        String prescribedMedication = null;

        babyId = recordBabyId( record );
        userId = recordUserId( record );
        id = record.getId();
        visitDate = record.getVisitDate();
        hospitalName = record.getHospitalName();
        symptoms = record.getSymptoms();
        diagnosis = record.getDiagnosis();
        prescribedMedication = record.getPrescribedMedication();

        HospitalVisitRecordDto hospitalVisitRecordDto = new HospitalVisitRecordDto( id, babyId, userId, visitDate, hospitalName, symptoms, diagnosis, prescribedMedication );

        return hospitalVisitRecordDto;
    }

    private Long recordBabyId(HospitalVisitRecord hospitalVisitRecord) {
        if ( hospitalVisitRecord == null ) {
            return null;
        }
        Baby baby = hospitalVisitRecord.getBaby();
        if ( baby == null ) {
            return null;
        }
        Long id = baby.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long recordUserId(HospitalVisitRecord hospitalVisitRecord) {
        if ( hospitalVisitRecord == null ) {
            return null;
        }
        User user = hospitalVisitRecord.getUser();
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
