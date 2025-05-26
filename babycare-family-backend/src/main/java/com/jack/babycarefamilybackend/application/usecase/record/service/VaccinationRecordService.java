package com.jack.babycarefamilybackend.application.usecase.record.service;

import com.jack.babycarefamilybackend.common.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.port.repository.BabyRepository;
import com.jack.babycarefamilybackend.domain.port.repository.UserRepository;
import com.jack.babycarefamilybackend.domain.port.repository.VaccinationRecordRepository;
import com.jack.babycarefamilybackend.domain.record.VaccinationRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.mapper.record.VaccinationRecordMapper;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.VaccinationRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateVaccinationRecordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VaccinationRecordService {

     VaccinationRecordDto createVaccinationRecord(CreateVaccinationRecordRequest request) ;

     List<VaccinationRecordDto> getRecordsByBabyId(Long babyId) ;

     List<VaccinationRecordDto> getRecordsByUserId(Long userId) ;
}
