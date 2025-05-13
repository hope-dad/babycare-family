package com.jack.babycarefamilybackend.application.usecase.baby;

import com.jack.babycarefamilybackend.infrastructure.web.dto.baby.BabyDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.baby.CreateBabyRequest;
import com.jack.babycarefamilybackend.infrastructure.web.dto.baby.UpdateBabyRequest;

import java.util.List;

public interface BabyService {

    /**
     * 아기 생성
     */
    BabyDto createBaby(CreateBabyRequest request);

    /**
     * 가족 그룹 내 아기 목록 조회
     */
    List<BabyDto> getBabiesByFamilyGroup(Long familyGroupId);

    /**
     * 아기 단건 조회
     */
    BabyDto getBabyById(Long babyId);

    /**
     * 아기 정보 업데이트
     */
    BabyDto updateBaby(Long babyId, UpdateBabyRequest request);

    /**
     * 아기 삭제
     */
    void deleteBaby(Long babyId);

    /**
     * 아기 존재 여부 확인
     */
    boolean existsById(Long babyId);
}
