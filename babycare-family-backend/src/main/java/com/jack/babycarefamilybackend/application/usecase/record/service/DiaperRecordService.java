package com.jack.babycarefamilybackend.application.usecase.record.service;

import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.DiaperRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateDiaperRecordRequest;

import java.util.List;

public interface DiaperRecordService {

    DiaperRecordDto createDiaperRecord(CreateDiaperRecordRequest request);

    List<DiaperRecordDto> getRecordsByBabyId(Long babyId);

    List<DiaperRecordDto> getRecordsByUserId(Long userId);
}
