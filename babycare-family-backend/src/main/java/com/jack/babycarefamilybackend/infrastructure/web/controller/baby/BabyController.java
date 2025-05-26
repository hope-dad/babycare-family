package com.jack.babycarefamilybackend.infrastructure.web.controller.baby;

import com.jack.babycarefamilybackend.application.usecase.baby.BabyService;
import com.jack.babycarefamilybackend.infrastructure.web.dto.baby.BabyDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.baby.CreateBabyRequest;
import com.jack.babycarefamilybackend.infrastructure.web.dto.baby.UpdateBabyRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.version.full-prefix}/babies")
@RequiredArgsConstructor
@Tag(name = "Baby", description = "아기 관리 API v1")
public class BabyController {

    private final BabyService babyService;

    /**
     * 아기 생성
     */
    @Operation(summary = "아기 생성", description = "새로운 아기 정보를 생성합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "아기 생성 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청"),
            @ApiResponse(responseCode = "500", description = "서버 에러")
    })
    @PostMapping
    public ResponseEntity<BabyDto> createBaby(@Valid @RequestBody CreateBabyRequest request) {
        BabyDto createdBaby = babyService.createBaby(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBaby);
    }

    /**
     * 가족 그룹 내 아기 목록 조회
     */
    @Operation(summary = "가족 그룹 아기 목록 조회", description = "특정 가족 그룹의 모든 아기 목록을 조회합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "404", description = "가족 그룹을 찾을 수 없음")
    })
    @GetMapping("/family-group/{familyGroupId}")
    public ResponseEntity<List<BabyDto>> getBabiesByFamilyGroup(@PathVariable Long familyGroupId) {
        List<BabyDto> babies = babyService.getBabiesByFamilyGroup(familyGroupId);
        return ResponseEntity.ok(babies);
    }

    /**
     * 아기 단건 조회
     */
    @Operation(summary = "아기 단건 조회", description = "아기 ID로 상세 정보를 조회합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공"),
            @ApiResponse(responseCode = "404", description = "아기를 찾을 수 없음")
    })
    @GetMapping("/{babyId}")
    public ResponseEntity<BabyDto> getBabyById(@PathVariable Long babyId) {
        BabyDto baby = babyService.getBabyById(babyId);
        return ResponseEntity.ok(baby);
    }

    /**
     * 아기 정보 업데이트
     */
    @Operation(summary = "아기 정보 수정", description = "기존 아기 정보를 수정합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "수정 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청"),
            @ApiResponse(responseCode = "404", description = "아기를 찾을 수 없음")
    })
    @PutMapping("/{babyId}")
    public ResponseEntity<BabyDto> updateBaby(
            @PathVariable Long babyId,
            @Valid @RequestBody UpdateBabyRequest request
    ) {
        BabyDto updatedBaby = babyService.updateBaby(babyId, request);
        return ResponseEntity.ok(updatedBaby);
    }

    /**
     * 아기 삭제
     */
    @Operation(summary = "아기 삭제", description = "아기 정보를 삭제합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "삭제 성공"),
            @ApiResponse(responseCode = "404", description = "아기를 찾을 수 없음")
    })
    @DeleteMapping("/{babyId}")
    public ResponseEntity<Void> deleteBaby(@PathVariable Long babyId) {
        babyService.deleteBaby(babyId);
        return ResponseEntity.noContent().build();
    }
}