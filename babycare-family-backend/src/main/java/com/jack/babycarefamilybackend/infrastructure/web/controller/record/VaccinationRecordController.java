package com.jack.babycarefamilybackend.infrastructure.web.controller.record;

import com.jack.babycarefamilybackend.application.usecase.record.VaccinationRecordService;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.VaccinationRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateVaccinationRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vaccination-records")
@RequiredArgsConstructor
public class VaccinationRecordController {

    private final VaccinationRecordService vaccinationRecordService;

    @PostMapping
    public ResponseEntity<VaccinationRecordDto> createRecord(@RequestBody CreateVaccinationRecordRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vaccinationRecordService.createVaccinationRecord(request));
    }

    @GetMapping("/baby/{babyId}")
    public ResponseEntity<List<VaccinationRecordDto>> getRecordsByBaby(@PathVariable Long babyId) {
        return ResponseEntity.ok(vaccinationRecordService.getRecordsByBabyId(babyId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<VaccinationRecordDto>> getRecordsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(vaccinationRecordService.getRecordsByUserId(userId));
    }
}
