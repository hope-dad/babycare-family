package com.jack.babycarefamilybackend.application.record.mapper;

import com.jack.babycarefamilybackend.domain.record.BabyRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.dto.record.dto.BabyRecordDto;
import com.jack.babycarefamilybackend.dto.record.request.CreateBabyRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BabyRecordMapper {

    @Mapping(target = "user", source = "user")
    BabyRecord toEntity(CreateBabyRecordRequest request, User user);

    @Mapping(source = "user.id", target = "userId")
    BabyRecordDto toDto(BabyRecord record);

}