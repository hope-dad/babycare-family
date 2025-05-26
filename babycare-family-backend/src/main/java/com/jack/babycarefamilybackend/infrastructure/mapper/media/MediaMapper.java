package com.jack.babycarefamilybackend.infrastructure.mapper.media;

import com.jack.babycarefamilybackend.domain.media.Media;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.web.dto.media.CreateMediaRequest;
import com.jack.babycarefamilybackend.infrastructure.web.dto.media.MediaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MediaMapper {

    default Media toEntity(CreateMediaRequest request, User uploader) {
        return Media.create(
                request.url(),
                request.type(),
                request.recordType(),
                request.recordId(),
                uploader
        );
    }

    @Mapping(target = "uploadedById", source = "uploadedBy.id") // Media.uploadedBy.id -> MediaDto.uploadedById
    @Mapping(target = "createdAt", source = "createdAt") // BaseTimeEntity 필드 매핑 (Audit 필드는 매핑 명시가 필요할 때도 있음)
    @Mapping(target = "updatedAt", source = "updatedAt")
    MediaDto toDto(Media media);


}
