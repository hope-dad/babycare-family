package com.jack.babycarefamilybackend.presentation.baby;

import com.jack.babycarefamilybackend.application.baby.BabyService;
import com.jack.babycarefamilybackend.dto.baby.BabyDto;
import com.jack.babycarefamilybackend.dto.baby.CreateBabyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/babies")
@RequiredArgsConstructor
public class BabyController {

    private final BabyService babyService;

    @PostMapping
    public ResponseEntity<BabyDto> createBaby(@RequestBody CreateBabyRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(babyService.createBaby(request));
    }

    @GetMapping("/family/{familyGroupId}")
    public ResponseEntity<List<BabyDto>> getBabiesByFamilyGroup(@PathVariable Long familyGroupId) {
        return ResponseEntity.ok(babyService.getBabiesByFamilyGroup(familyGroupId));
    }
}