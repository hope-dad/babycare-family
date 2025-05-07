package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.BabyRepository;
import com.jack.babycarefamilybackend.domain.record.VaccinationRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import com.jack.babycarefamilybackend.dto.record.dto.VaccinationRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateVaccinationRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VaccinationRecordMapper {


    public VaccinationRecord toEntity(CreateVaccinationRecordRequest request, Baby baby, User user) {

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
