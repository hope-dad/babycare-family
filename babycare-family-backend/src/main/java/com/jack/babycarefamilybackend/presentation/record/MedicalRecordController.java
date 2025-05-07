package com.jack.babycarefamilybackend.presentation.record;

import com.jack.babycarefamilybackend.application.record.service.MedicalRecordService;
import com.jack.babycarefamilybackend.dto.record.dto.MedicalRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateMedicalRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @PostMapping
    public ResponseEntity<MedicalRecordDto> createRecord(@RequestBody CreateMedicalRecordRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicalRecordService.createMedicalRecord(request));
    }

    @GetMapping("/baby/{babyId}")
    public ResponseEntity<List<MedicalRecordDto>> getRecordsByBaby(@PathVariable Long babyId) {
        return ResponseEntity.ok(medicalRecordService.getRecordsByBabyId(babyId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MedicalRecordDto>> getRecordsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(medicalRecordService.getRecordsByUserId(userId));
    }
}