package com.jack.babycarefamilybackend.application.usecase.record.service;

import com.jack.babycarefamilybackend.common.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.domain.port.repository.BabyRecordRepository;
import com.jack.babycarefamilybackend.domain.port.repository.UserRepository;
import com.jack.babycarefamilybackend.domain.record.BabyRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.mapper.record.BabyRecordMapper;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.BabyRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateBabyRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BabyRecordService {
    private final BabyRecordMapper babyRecordMapper;

    private final BabyRecordRepository babyRecordRepository;
    private final UserRepository userRepository;

    public BabyRecordDto create(CreateBabyRecordRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ResourceNotFoundException("User", request.userId(), "User with ID" + request.userId(), "Not Found"));
        BabyRecord record = babyRecordMapper.toEntity(request, user);
        return babyRecordMapper.toDto(babyRecordRepository.save(record));
    }

    public List<BabyRecordDto> findAll() {
        return babyRecordRepository.findAll()
                .stream()
                .map(babyRecordMapper::toDto)
                .toList();
    }
}
