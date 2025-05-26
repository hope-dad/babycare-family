package com.jack.babycarefamilybackend.application.usecase.record.service;


import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.SleepRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateSleepRecordRequest;

import java.util.List;

public interface SleepRecordService {


    SleepRecordDto createSleepRecord(CreateSleepRecordRequest request);

    List<SleepRecordDto> getRecordsByBabyId(Long babyId);

    List<SleepRecordDto> getRecordsByUserId(Long userId);
}