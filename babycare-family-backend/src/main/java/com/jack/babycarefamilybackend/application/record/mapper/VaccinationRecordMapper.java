package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.BabyRepository;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VaccinationRecordMapper {

    private final BabyRepository babyRepository;
    private final UserRepository userRepository;

    public VaccinationRecord toEntity(CreateVaccinationRecordRequest request) {
        Baby baby = babyRepository.findById(request.babyId())
                .orElseThrow(() -> new IllegalArgumentException("Baby not found"));

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return new VaccinationRecord(
                baby,
                user,
                request.vaccineName(),
                request.vaccinationDate(),
                request.nextVaccinationDate(),
                request.note()
        );
    }

    public VaccinationRecordDto toDto(VaccinationRecord record) {
        return new VaccinationRecordDto(
                record.getId(),
                record.getBaby().getId(),
                record.getUser().getId(),
                record.getVaccineName(),
                record.getVaccinationDate(),
                record.getNextVaccinationDate(),
                record.getNote()
        );
    }
}
