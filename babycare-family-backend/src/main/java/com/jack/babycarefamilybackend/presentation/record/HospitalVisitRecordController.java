package com.jack.babycarefamilybackend.presentation.record;

import com.jack.babycarefamilybackend.application.record.service.HospitalVisitRecordService;
import com.jack.babycarefamilybackend.dto.record.dto.HospitalVisitRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateHospitalVisitRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospital-visit-records")
@RequiredArgsConstructor
public class HospitalVisitRecordController {

    private final HospitalVisitRecordService hospitalVisitRecordService;

    @PostMapping
    public ResponseEntity<HospitalVisitRecordDto> create(@RequestBody CreateHospitalVisitRecordRequest request) {
        return ResponseEntity.ok(hospitalVisitRecordService.createRecord(request));
    }

    @GetMapping("/baby/{babyId}")
    public ResponseEntity<List<HospitalVisitRecordDto>> getByBaby(@PathVariable Long babyId) {
        return ResponseEntity.ok(hospitalVisitRecordService.getByBabyId(babyId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<HospitalVisitRecordDto>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(hospitalVisitRecordService.getByUserId(userId));
    }
}