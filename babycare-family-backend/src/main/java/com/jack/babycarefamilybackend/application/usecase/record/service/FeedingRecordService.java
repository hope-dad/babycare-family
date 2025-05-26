package com.jack.babycarefamilybackend.application.usecase.record.service;

import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.FeedingRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateFeedingRecordRequest;

import java.util.List;

public interface FeedingRecordService {


     FeedingRecordDto createFeedingRecord(CreateFeedingRecordRequest request);

     List<FeedingRecordDto> getRecordsByBabyId(Long babyId);

     List<FeedingRecordDto> getRecordsByUserId(Long userId);
}
