package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.baby.BabyRepository;
import com.jack.babycarefamilybackend.domain.record.DiaperRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import com.jack.babycarefamilybackend.dto.record.dto.DiaperRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateDiaperRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiaperRecordMapper {

    private final BabyRepository babyRepository;
    private final UserRepository userRepository;

    public DiaperRecord toEntity(CreateDiaperRecordRequest request, Baby baby, User user) {


        return new DiaperRecord(
                baby,
                user,
                request.type(),
                request.note(),
                request.changedAt()
        );
    }

    public DiaperRecordDto toDto(DiaperRecord diaperRecord) {
        return new DiaperRecordDto(
                diaperRecord.getId(),
                diaperRecord.getBaby().getId(),
                diaperRecord.getUser().getId(),
                diaperRecord.getType(),
                diaperRecord.getNote(),
                diaperRecord.getChangedAt()
        );
    }
}