package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.record.BabyRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.BabyRecordDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.request.CreateBabyRecordRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
@Named("babyRecordMapper")
public interface BabyRecordMapper {

    default BabyRecord toEntity(CreateBabyRecordRequest request, User user) {
        return BabyRecord.create(
                request.content(),
                user
        );
    }

    @Mappings({@Mapping(target = "userId", source = "user.id")})
    BabyRecordDto toDto(BabyRecord record);


}