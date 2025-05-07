package com.jack.babycarefamilybackend.presentation.record;

import com.jack.babycarefamilybackend.application.record.service.MilestoneRecordService;
import com.jack.babycarefamilybackend.dto.record.dto.MilestoneRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateMilestoneRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/milestone-records")
@RequiredArgsConstructor
public class MilestoneRecordController {

    private final MilestoneRecordService milestoneRecordService;

    @PostMapping
    public ResponseEntity<MilestoneRecordDto> create(@RequestBody CreateMilestoneRecordRequest request) {
        return ResponseEntity.ok(milestoneRecordService.createMilestone(request));
    }

    @GetMapping("/baby/{babyId}")
    public ResponseEntity<List<MilestoneRecordDto>> getByBaby(@PathVariable Long babyId) {
        return ResponseEntity.ok(milestoneRecordService.getByBabyId(babyId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MilestoneRecordDto>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(milestoneRecordService.getByUserId(userId));
    }
}
