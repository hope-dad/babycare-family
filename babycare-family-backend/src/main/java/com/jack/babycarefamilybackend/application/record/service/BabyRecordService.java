package com.jack.babycarefamilybackend.application.record.service;

import com.jack.babycarefamilybackend.application.record.mapper.BabyRecordMapper;
import com.jack.babycarefamilybackend.domain.record.BabyRecord;
import com.jack.babycarefamilybackend.domain.record.repository.BabyRecordRepository;
import com.jack.babycarefamilybackend.dto.record.dto.BabyRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateBabyRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BabyRecordService {
    private final BabyRecordRepository babyRecordRepository;
    private final BabyRecordMapper babyRecordMapper;

    public BabyRecordDto create(CreateBabyRecordRequest request) {
        BabyRecord record = babyRecordMapper.toEntity(request);
        return babyRecordMapper.toDto(babyRecordRepository.save(record));
    }

    public List<BabyRecordDto> findAll() {
        return babyRecordRepository.findAll()
                .stream()
                .map(babyRecordMapper::toDto)
                .toList();
    }
}
