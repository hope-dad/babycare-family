package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.BabyRepository;
import com.jack.babycarefamilybackend.domain.record.MilestoneRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import com.jack.babycarefamilybackend.dto.record.dto.MilestoneRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateMilestoneRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MilestoneRecordMapper {

    private final BabyRepository babyRepository;
    private final UserRepository userRepository;

    public MilestoneRecord toEntity(CreateMilestoneRecordRequest request) {
        Baby baby = babyRepository.findById(request.babyId())
                .orElseThrow(() -> new IllegalArgumentException("Baby not found"));
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return new MilestoneRecord(
                baby,
                user,
                request.eventName(),
                request.date(),
                request.note(),
                request.photoUrl()
        );
    }

    public MilestoneRecordDto toDto(MilestoneRecord record) {
        return new MilestoneRecordDto(
                record.getId(),
                record.getBaby().getId(),
                record.getUser().getId(),
                record.getEventName(),
                record.getDate(),
                record.getNote(),
                record.getPhotoUrl()
        );
    }
}
