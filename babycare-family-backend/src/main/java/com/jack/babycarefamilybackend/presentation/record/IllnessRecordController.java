package com.jack.babycarefamilybackend.presentation.record;

import com.jack.babycarefamilybackend.application.record.service.IllnessRecordService;
import com.jack.babycarefamilybackend.dto.record.dto.IllnessRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateIllnessRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/illness-records")
@RequiredArgsConstructor
public class IllnessRecordController {

    private final IllnessRecordService illnessRecordService;

    @PostMapping
    public ResponseEntity<IllnessRecordDto> create(@RequestBody CreateIllnessRecordRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(illnessRecordService.createIllnessRecord(request));
    }

    @GetMapping("/baby/{babyId}")
    public ResponseEntity<List<IllnessRecordDto>> getByBaby(@PathVariable Long babyId) {
        return ResponseEntity.ok(illnessRecordService.getByBabyId(babyId));
    }
}