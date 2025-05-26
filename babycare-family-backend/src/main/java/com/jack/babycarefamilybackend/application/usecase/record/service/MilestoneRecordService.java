package com.jack.babycarefamilybackend.application.usecase.record.service;

import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.MilestoneRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateMilestoneRecordRequest;

import java.util.List;

public interface MilestoneRecordService {


    MilestoneRecordDto createMilestone(CreateMilestoneRecordRequest request);

    List<MilestoneRecordDto> getByBabyId(Long babyId);

     List<MilestoneRecordDto> getByUserId(Long userId);
}
