package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.DiaperRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.dto.record.dto.DiaperRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateDiaperRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DiaperRecordMapper {


    @Mapping(target = "baby", source = "baby")
    @Mapping(target = "user", source = "user")
    DiaperRecord toEntity(CreateDiaperRecordRequest request, Baby baby, User user);

    @Mapping(source = "baby.id", target = "babyId")
    @Mapping(source = "user.id", target = "userId")
    DiaperRecordDto toDto(DiaperRecord diaperRecord);
}