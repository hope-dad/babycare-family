package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.BabyRepository;
import com.jack.babycarefamilybackend.domain.record.HospitalVisitRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import com.jack.babycarefamilybackend.dto.record.dto.HospitalVisitRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateHospitalVisitRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HospitalVisitRecordMapper {



    public HospitalVisitRecord toEntity(CreateHospitalVisitRecordRequest request, Baby baby, User user) {



        return new HospitalVisitRecord(
                baby,
                user,
                request.visitDate(),
                request.hospitalName(),
                request.symptoms(),
                request.diagnosis(),
                request.prescribedMedication()
        );
    }

    public HospitalVisitRecordDto toDto(HospitalVisitRecord record) {
        return new HospitalVisitRecordDto(
                record.getId(),
                record.getBaby().getId(),
                record.getUser().getId(),
                record.getVisitDate(),
                record.getHospitalName(),
                record.getSymptoms(),
                record.getDiagnosis(),
                record.getPrescribedMedication()
        );
    }
}
