package com.jack.babycarefamilybackend.application.usecase.record.service;

import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.MedicalRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateMedicalRecordRequest;

import java.util.List;

public interface MedicalRecordService {

    MedicalRecordDto createMedicalRecord(CreateMedicalRecordRequest request);

    List<MedicalRecordDto> getRecordsByBabyId(Long babyId);

    List<MedicalRecordDto> getRecordsByUserId(Long userId);
}