package com.jack.babycarefamilybackend.application.usecase.record.service;


import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.BabyRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateBabyRecordRequest;

import java.util.List;

public interface BabyRecordService {

     BabyRecordDto create(CreateBabyRecordRequest request);

     List<BabyRecordDto> findAll();
}
