package com.jack.babycarefamilybackend.application.usecase.schedule;

import com.jack.babycarefamilybackend.common.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.port.repository.BabyRepository;
import com.jack.babycarefamilybackend.domain.port.repository.ScheduleRepository;
import com.jack.babycarefamilybackend.domain.port.repository.UserRepository;
import com.jack.babycarefamilybackend.domain.schedule.Schedule;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.mapper.schedule.ScheduleMapper;
import com.jack.babycarefamilybackend.infrastructure.web.dto.schedule.CreateScheduleRequest;
import com.jack.babycarefamilybackend.infrastructure.web.dto.schedule.ScheduleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;
    private final BabyRepository babyRepository;
    private final UserRepository userRepository;


    @Transactional
    public ScheduleDto createSchedule(CreateScheduleRequest request) {

        Baby baby = babyRepository.findById(request.babyId())
                .orElseThrow(() -> new ResourceNotFoundException("Baby", request.babyId(), "Baby with ID", request.babyId() + "not found"));

        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new ResourceNotFoundException("User", request.userId(), "user with Id", request.userId() + "not found"));
        Schedule schedule = scheduleMapper.toEntity(request, baby, user);
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