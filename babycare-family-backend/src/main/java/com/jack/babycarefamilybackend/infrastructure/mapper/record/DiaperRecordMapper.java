package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.DiaperRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.DiaperRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateDiaperRecordRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiaperRecordMapper {


    DiaperRecord toEntity(CreateDiaperRecordRequest request, Baby baby, User user);

    DiaperRecordDto toDto(DiaperRecord diaperRecord);
}