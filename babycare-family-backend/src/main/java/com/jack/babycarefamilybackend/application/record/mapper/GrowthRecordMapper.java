package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.BabyRepository;
import com.jack.babycarefamilybackend.domain.record.GrowthRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import com.jack.babycarefamilybackend.dto.record.dto.GrowthRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateGrowthRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GrowthRecordMapper {

    private final BabyRepository babyRepository;
    private final UserRepository userRepository;

    public GrowthRecord toEntity(CreateGrowthRecordRequest request) {
        Baby baby = babyRepository.findById(request.babyId())
                .orElseThrow(() -> new IllegalArgumentException("Baby not found"));

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return new GrowthRecord(
                baby,
                user,
                request.height(),
                request.weight(),
                request.headCircumference(),
                request.recordedAt(),
                request.note()
        );
    }

    public GrowthRecordDto toDto(GrowthRecord growthRecord) {
        return new GrowthRecordDto(
                growthRecord.getId(),
                growthRecord.getBaby().getId(),
                growthRecord.getUser().getId(),
                growthRecord.getHeight(),
                growthRecord.getWeight(),
                growthRecord.getHeadCircumference(),
                growthRecord.getRecordedAt(),
                growthRecord.getNote()
        );
    }
}