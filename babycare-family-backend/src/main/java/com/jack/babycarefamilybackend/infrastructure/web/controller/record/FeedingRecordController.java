package com.jack.babycarefamilybackend.infrastructure.web.controller.record;

import com.jack.babycarefamilybackend.application.usecase.record.service.FeedingRecordService;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateFeedingRecordRequest;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.FeedingRecordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feeding-records")
@RequiredArgsConstructor
public class FeedingRecordController {

    private final FeedingRecordService feedingRecordService;

    @PostMapping
    public ResponseEntity<FeedingRecordDto> createFeedingRecord(@RequestBody CreateFeedingRecordRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(feedingRecordService.createFeedingRecord(request));
    }

    @GetMapping("/baby/{babyId}")
    public ResponseEntity<List<FeedingRecordDto>> getRecordsByBaby(@PathVariable Long babyId) {
        return ResponseEntity.ok(feedingRecordService.getRecordsByBabyId(babyId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FeedingRecordDto>> getRecordsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(feedingRecordService.getRecordsByUserId(userId));
    }
}
