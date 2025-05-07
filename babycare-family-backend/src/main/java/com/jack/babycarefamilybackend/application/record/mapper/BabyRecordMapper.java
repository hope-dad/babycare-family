package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.record.BabyRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import com.jack.babycarefamilybackend.dto.record.dto.BabyRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateBabyRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BabyRecordMapper {
    private final UserRepository userRepository;

    public BabyRecord toEntity(CreateBabyRecordRequest request, User user) {

        return new BabyRecord(request.content(), user);
    }

    public BabyRecordDto toDto(BabyRecord record) {
        return new BabyRecordDto(record.getId(), record.getContent(), record.getUser().getId());
    }
}