package com.jack.babycarefamilybackend.application.usecase.record.service;

import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.GrowthRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateGrowthRecordRequest;

import java.util.List;

public interface GrowthRecordService {


    GrowthRecordDto createGrowthRecord(CreateGrowthRecordRequest request);

    List<GrowthRecordDto> getRecordsByBabyId(Long babyId);

    List<GrowthRecordDto> getRecordsByUserId(Long userId);
}
