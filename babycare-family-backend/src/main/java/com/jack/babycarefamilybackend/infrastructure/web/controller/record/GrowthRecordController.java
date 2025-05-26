package com.jack.babycarefamilybackend.infrastructure.web.controller.record;

import com.jack.babycarefamilybackend.application.usecase.record.GrowthRecordService;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.GrowthRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateGrowthRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/growth-records")
@RequiredArgsConstructor
public class GrowthRecordController {

    private final GrowthRecordService growthRecordService;

    @PostMapping
    public ResponseEntity<GrowthRecordDto> createGrowthRecord(@RequestBody CreateGrowthRecordRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(growthRecordService.createGrowthRecord(request));
    }

    @GetMapping("/baby/{babyId}")
    public ResponseEntity<List<GrowthRecordDto>> getRecordsByBaby(@PathVariable Long babyId) {
        return ResponseEntity.ok(growthRecordService.getRecordsByBabyId(babyId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<GrowthRecordDto>> getRecordsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(growthRecordService.getRecordsByUserId(userId));
    }
}
