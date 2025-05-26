package com.jack.babycarefamilybackend.infrastructure.mapper.record;

import com.jack.babycarefamilybackend.domain.record.BabyRecord;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.record.dto.BabyRecordDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-26T13:42:44+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class BabyRecordMapperImpl implements BabyRecordMapper {

    @Override
    public BabyRecordDto toDto(BabyRecord record) {
        if ( record == null ) {
            return null;
        }

        Long userId = null;
        Long id = null;
        String content = null;

        userId = recordUserId( record );
        id = record.getId();
        content = record.getContent();

        BabyRecordDto babyRecordDto = new BabyRecordDto( id, content, userId );

        return babyRecordDto;
    }

    private Long recordUserId(BabyRecord babyRecord) {
        if ( babyRecord == null ) {
            return null;
        }
        User user = babyRecord.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
