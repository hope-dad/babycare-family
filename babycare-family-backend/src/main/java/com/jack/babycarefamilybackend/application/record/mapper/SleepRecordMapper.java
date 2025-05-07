package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.BabyRepository;
import com.jack.babycarefamilybackend.domain.record.SleepRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import com.jack.babycarefamilybackend.dto.record.dto.SleepRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateSleepRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SleepRecordMapper {

    private final BabyRepository babyRepository;
    private final UserRepository userRepository;

    public SleepRecord toEntity(CreateSleepRecordRequest request) {
        Baby baby = babyRepository.findById(request.babyId())
                .orElseThrow(() -> new IllegalArgumentException("Baby not found"));

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return new SleepRecord(
                baby,
                user,
                request.sleepStart(),
                request.sleepEnd(),
                request.note()
        );
    }

    public SleepRecordDto toDto(SleepRecord sleepRecord) {
        return new SleepRecordDto(
                sleepRecord.getId(),
                sleepRecord.getBaby().getId(),
                sleepRecord.getUser().getId(),
                sleepRecord.getSleepStart(),
                sleepRecord.getSleepEnd(),
                sleepRecord.getNote()
        );
    }
}
