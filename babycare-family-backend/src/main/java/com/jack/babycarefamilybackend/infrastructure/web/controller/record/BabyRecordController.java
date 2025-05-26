package com.jack.babycarefamilybackend.infrastructure.web.controller.record;

import com.jack.babycarefamilybackend.application.usecase.record.BabyRecordService;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.BabyRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateBabyRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baby-records")
@RequiredArgsConstructor
public class BabyRecordController {
    private final BabyRecordService babyRecordService;

    @PostMapping
    public ResponseEntity<BabyRecordDto> create(@RequestBody CreateBabyRecordRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(babyRecordService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<BabyRecordDto>> getAll() {
        return ResponseEntity.ok(babyRecordService.findAll());
    }
}