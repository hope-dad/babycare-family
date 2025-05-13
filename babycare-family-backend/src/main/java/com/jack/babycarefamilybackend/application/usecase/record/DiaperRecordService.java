package com.jack.babycarefamilybackend.application.usecase.record;

import com.jack.babycarefamilybackend.common.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.infrastructure.mapper.record.DiaperRecordMapper;
import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.port.repository.BabyRepository;
import com.jack.babycarefamilybackend.domain.record.DiaperRecord;
import com.jack.babycarefamilybackend.domain.port.repository.DiaperRecordRepository;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.port.repository.UserRepository;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.DiaperRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateDiaperRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiaperRecordService {

    private final DiaperRecordMapper diaperRecordMapper;

    private final DiaperRecordRepository diaperRecordRepository;
    private final BabyRepository babyRepository;
    private final UserRepository userRepository;

    @Transactional
    public DiaperRecordDto createDiaperRecord(CreateDiaperRecordRequest request) {

        Baby baby = babyRepository.findById(request.babyId())
                .orElseThrow(() -> new ResourceNotFoundException("Baby", request.babyId(), "Baby with ID",request.babyId() + "not found"));

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ResourceNotFoundException("User", request.userId(), "user with Id", request.userId() + "not found"));

        DiaperRecord diaperRecord = diaperRecordMapper.toEntity(request, baby, user);
        DiaperRecord savedRecord = diaperRecordRepository.save(diaperRecord);
        return diaperRecordMapper.toDto(savedRecord);
    }

    @Transactional(readOnly = true)
    public List<DiaperRecordDto> getRecordsByBabyId(Long babyId) {
        return diaperRecordRepository.findByBabyId(babyId)
                .stream()
                .map(diaperRecordMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<DiaperRecordDto> getRecordsByUserId(Long userId) {
        return diaperRecordRepository.findByUserId(userId)
                .stream()
                .map(diaperRecordMapper::toDto)
                .toList();
    }
}
