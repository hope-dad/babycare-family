package com.jack.babycarefamilybackend.application.usecase.record.service;

import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.HospitalVisitRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateHospitalVisitRecordRequest;

import java.util.List;

public interface HospitalVisitRecordService {

    HospitalVisitRecordDto createRecord(CreateHospitalVisitRecordRequest request);
    List<HospitalVisitRecordDto> getByBabyId(Long babyId);
    List<HospitalVisitRecordDto> getByUserId(Long userId);
}