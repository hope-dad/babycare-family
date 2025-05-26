package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.MedicalRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.MedicalRecordDto;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-26T16:22:22+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class MedicalRecordMapperImpl implements MedicalRecordMapper {

    @Override
    public MedicalRecordDto toDto(MedicalRecord record) {
        if ( record == null ) {
            return null;
        }

        Long babyId = null;
        Long userId = null;
        Long id = null;
        String diagnosis = null;
        String treatment = null;
        String prescribedMedication = null;
        LocalDateTime visitDate = null;
        String doctorName = null;
        String note = null;

        babyId = recordBabyId( record );
        userId = recordUserId( record );
        id = record.getId();
        diagnosis = record.getDiagnosis();
        treatment = record.getTreatment();
        prescribedMedication = record.getPrescribedMedication();
        visitDate = record.getVisitDate();
        doctorName = record.getDoctorName();
        note = record.getNote();

        MedicalRecordDto medicalRecordDto = new MedicalRecordDto( id, babyId, userId, diagnosis, treatment, prescribedMedication, visitDate, doctorName, note );

        return medicalRecordDto;
    }

    private Long recordBabyId(MedicalRecord medicalRecord) {
        if ( medicalRecord == null ) {
            return null;
        }
        Baby baby = medicalRecord.getBaby();
        if ( baby == null ) {
            return null;
        }
        Long id = baby.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long recordUserId(MedicalRecord medicalRecord) {
        if ( medicalRecord == null ) {
            return null;
        }
        User user = medicalRecord.getUser();
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
