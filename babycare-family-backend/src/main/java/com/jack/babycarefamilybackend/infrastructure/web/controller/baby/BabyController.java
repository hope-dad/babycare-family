package com.jack.babycarefamilybackend.infrastructure.web.controller.baby;

import com.jack.babycarefamilybackend.application.usecase.baby.BabyService;
import com.jack.babycarefamilybackend.infrastructure.web.dto.baby.BabyDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.baby.CreateBabyRequest;
import com.jack.babycarefamilybackend.infrastructure.web.dto.baby.UpdateBabyRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/babies")
@RequiredArgsConstructor
@Tag(name ="Baby", description = "아기 관리 API")
public class BabyController {

    private final BabyService babyService;

    /**
     * 아기 생성
     */
    @PostMapping
    public ResponseEntity<BabyDto> createBaby(@RequestBody CreateBabyRequest request) {
        BabyDto createdBaby = babyService.createBaby(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBaby);
    }

    /**
     * 가족 그룹 내 아기 목록 조회
     */
    @GetMapping("/family-group/{familyGroupId}")
    public ResponseEntity<List<BabyDto>> getBabiesByFamilyGroup(@PathVariable Long familyGroupId) {
        List<BabyDto> babies = babyService.getBabiesByFamilyGroup(familyGroupId);
        return ResponseEntity.ok(babies);
    }

    /**
     * 아기 단건 조회
     */
    @Operation(summary = "아기 단건 조회", description = "아기 ID로 상세 정보를 조회합니다")
    @GetMapping("/{babyId}")
    public ResponseEntity<BabyDto> getBabyById(@PathVariable Long babyId) {
        BabyDto baby = babyService.getBabyById(babyId);
        return ResponseEntity.ok(baby);
    }

    /**
     * 아기 정보 업데이트
     */
    @PutMapping("/{babyId}")
    public ResponseEntity<BabyDto> updateBaby(
            @PathVariable Long babyId,
            @RequestBody UpdateBabyRequest request
    ) {
        BabyDto updatedBaby = babyService.updateBaby(babyId, request);
        return ResponseEntity.ok(updatedBaby);
    }

    /**
     * 아기 삭제
     */
    @DeleteMapping("/{babyId}")
    public ResponseEntity<Void> deleteBaby(@PathVariable Long babyId) {
        babyService.deleteBaby(babyId);
        return ResponseEntity.noContent().build();
    }
}