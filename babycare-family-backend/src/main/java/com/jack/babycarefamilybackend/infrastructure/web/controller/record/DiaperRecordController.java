package com.jack.babycarefamilybackend.infrastructure.web.controller.record;

import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.DiaperRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateDiaperRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diaper-records")
@RequiredArgsConstructor
public class DiaperRecordController {

    private final DiaperRecordService diaperRecordService;

    @PostMapping
    public ResponseEntity<DiaperRecordDto> createDiaperRecord(@RequestBody CreateDiaperRecordRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(diaperRecordService.createDiaperRecord(request));
    }

    @GetMapping("/baby/{babyId}")
    public ResponseEntity<List<DiaperRecordDto>> getRecordsByBaby(@PathVariable Long babyId) {
        return ResponseEntity.ok(diaperRecordService.getRecordsByBabyId(babyId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DiaperRecordDto>> getRecordsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(diaperRecordService.getRecordsByUserId(userId));
    }
}
