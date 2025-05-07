package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.BabyRepository;
import com.jack.babycarefamilybackend.domain.record.MedicalRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import com.jack.babycarefamilybackend.dto.record.dto.MedicalRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateMedicalRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MedicalRecordMapper {

    private final BabyRepository babyRepository;
    private final UserRepository userRepository;

    public MedicalRecord toEntity(CreateMedicalRecordRequest request) {
        Baby baby = babyRepository.findById(request.babyId())
                .orElseThrow(() -> new IllegalArgumentException("Baby not found"));

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return new MedicalRecord(
                baby,
                user,
                request.diagnosis(),
                request.treatment(),
                request.prescribedMedication(),
                request.visitDate(),
                request.doctorName(),
                request.note()
        );
    }

    public MedicalRecordDto toDto(MedicalRecord record) {
        return new MedicalRecordDto(
                record.getId(),
                record.getBaby().getId(),
                record.getUser().getId(),
                record.getDiagnosis(),
                record.getTreatment(),
                record.getPrescribedMedication(),
                record.getVisitDate(),
                record.getDoctorName(),
                record.getNote()
        );
    }
}
