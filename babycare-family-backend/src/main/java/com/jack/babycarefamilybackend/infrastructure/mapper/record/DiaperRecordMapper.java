package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.baby.Baby;
import com.jack.babycarefamilybackend.domain.record.DiaperRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.DiaperRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateDiaperRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface DiaperRecordMapper {


    default DiaperRecord toEntity(CreateDiaperRecordRequest request, User user, Baby baby) {
        return DiaperRecord.create(
                baby,
                user,
                request.type(),
                request.note(),
                request.changedAt()
        );
    }
    @Mappings({
            @org.mapstruct.Mapping(target = "babyId", source = "baby.id"),
            @org.mapstruct.Mapping(target = "userId", source = "user.id")
    })
    DiaperRecordDto toDto(DiaperRecord diaperRecord);
}