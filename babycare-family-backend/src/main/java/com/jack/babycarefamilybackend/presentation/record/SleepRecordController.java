package com.jack.babycarefamilybackend.presentation.record;

import com.jack.babycarefamilybackend.application.record.service.SleepRecordService;
import com.jack.babycarefamilybackend.dto.record.dto.SleepRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateSleepRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sleep-records")
@RequiredArgsConstructor
public class SleepRecordController {

    private final SleepRecordService sleepRecordService;

    @PostMapping
    public ResponseEntity<SleepRecordDto> createSleepRecord(@RequestBody CreateSleepRecordRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sleepRecordService.createSleepRecord(request));
    }

    @GetMapping("/baby/{babyId}")
    public ResponseEntity<List<SleepRecordDto>> getRecordsByBaby(@PathVariable Long babyId) {
        return ResponseEntity.ok(sleepRecordService.getRecordsByBabyId(babyId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SleepRecordDto>> getRecordsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(sleepRecordService.getRecordsByUserId(userId));
    }
}
