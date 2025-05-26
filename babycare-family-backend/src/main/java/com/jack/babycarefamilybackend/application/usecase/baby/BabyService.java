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

    // --- 아까 추가적으로 고려해볼 만한 메소드 제안 (필요하다면 추가) ---
    /*
     *//**
     * 아기를 특정 가족 그룹에 연결
     *//*
    void addBabyToFamilyGroup(Long babyId, Long familyGroupId);


    void removeBabyFromFamilyGroup(Long babyId, Long familyGroupId);

    *//**
     * 특정 유저와 연관된 (생성했거나 접근 가능한) 모든 아기 목록 조회
     *//*
    List<BabyDto> getBabiesByUser(Long userId);

    *//**
     * 아기 삭제 (논리적 삭제)
     *//*
    void softDeleteBaby(Long babyId);

    *//**
     * 논리적 삭제된 아기 복구
     *//*
    void restoreBaby(Long babyId);

    *//**
     * 특정 유저의 주요 아기 설정
     *//*
    void setPrimaryBaby(Long userId, Long babyId);
    */
}
