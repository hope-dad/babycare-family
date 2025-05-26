package com.jack.babycarefamilybackend.application.usecase.record.service;

import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.IllnessRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateIllnessRecordRequest;

import java.util.List;

public interface IllnessRecordService {

    IllnessRecordDto createIllnessRecord(CreateIllnessRecordRequest request);
    List<IllnessRecordDto> getByBabyId(Long babyId);
}
