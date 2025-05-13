package com.jack.babycarefamilybackend.infrastructure.web.controller.schedule;

import com.jack.babycarefamilybackend.application.usecase.schedule.ScheduleService;
import com.jack.babycarefamilybackend.infrastructure.web.dto.schedule.CreateScheduleRequest;
import com.jack.babycarefamilybackend.infrastructure.web.dto.schedule.ScheduleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleDto> create(@RequestBody CreateScheduleRequest request) {
        return ResponseEntity.ok(scheduleService.createSchedule(request));
    }

    @GetMapping("/baby/{babyId}")
    public ResponseEntity<List<ScheduleDto>> getByBaby(@PathVariable Long babyId) {
        return ResponseEntity.ok(scheduleService.getByBabyId(babyId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ScheduleDto>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(scheduleService.getByUserId(userId));
    }
}
