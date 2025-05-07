package com.jack.babycarefamilybackend.application.schedule;

import com.jack.babycarefamilybackend.domain.schedule.Schedule;
import com.jack.babycarefamilybackend.domain.schedule.ScheduleRepository;
import com.jack.babycarefamilybackend.dto.schedule.CreateScheduleRequest;
import com.jack.babycarefamilybackend.dto.schedule.ScheduleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;

    @Transactional
    public ScheduleDto createSchedule(CreateScheduleRequest request) {
        Schedule schedule = scheduleMapper.toEntity(request);
        return scheduleMapper.toDto(scheduleRepository.save(schedule));
    }

    @Transactional(readOnly = true)
    public List<ScheduleDto> getByBabyId(Long babyId) {
        return scheduleRepository.findByBabyId(babyId)
                .stream()
                .map(scheduleMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<ScheduleDto> getByUserId(Long userId) {
        return scheduleRepository.findByUserId(userId)
                .stream()
                .map(scheduleMapper::toDto)
                .toList();
    }
}