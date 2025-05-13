package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.record.BabyRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.BabyRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateBabyRecordRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BabyRecordMapper {

    BabyRecord toEntity(CreateBabyRecordRequest request, User user);

    BabyRecordDto toDto(BabyRecord record);

}