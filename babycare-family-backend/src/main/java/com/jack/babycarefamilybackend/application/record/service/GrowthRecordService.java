package com.jack.babycarefamilybackend.application.record.service;

import com.jack.babycarefamilybackend.application.record.mapper.GrowthRecordMapper;
import com.jack.babycarefamilybackend.dto.record.request.CreateGrowthRecordRequest;

@Service
@RequiredArgsConstructor
public class GrowthRecordService {

    private final GrowthRecordRepository growthRecordRepository;
    private final GrowthRecordMapper growthRecordMapper;

    @Transactional
    public GrowthRecordDto createGrowthRecord(CreateGrowthRecordRequest request) {
        GrowthRecord growthRecord = growthRecordMapper.toEntity(request);
        GrowthRecord savedRecord = growthRecordRepository.save(growthRecord);
        return growthRecordMapper.toDto(savedRecord);
    }

    @Transactional(readOnly = true)
    public List<GrowthRecordDto> getRecordsByBabyId(Long babyId) {
        return growthRecordRepository.findByBabyId(babyId)
                .stream()
                .map(growthRecordMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<GrowthRecordDto> getRecordsByUserId(Long userId) {
        return growthRecordRepository.findByUserId(userId)
                .stream()
                .map(growthRecordMapper::toDto)
                .toList();
    }
}
