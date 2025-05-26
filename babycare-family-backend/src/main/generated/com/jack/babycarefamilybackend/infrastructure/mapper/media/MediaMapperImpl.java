package com.jack.babycarefamilybackend.infrastructure.mapper.media;

import com.jack.babycarefamilybackend.domain.media.Media;
import com.jack.babycarefamilybackend.domain.media.MediaStatus;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRole;
import com.jack.babycarefamilybackend.infrastructure.web.dto.media.MediaDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.user.UserDto;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-26T16:23:26+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class MediaMapperImpl implements MediaMapper {

    @Override
    public MediaDto toDto(Media media) {
        if ( media == null ) {
            return null;
        }

        Long uploadedById = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;
        Long id = null;
        String url = null;
        MediaStatus type = null;
        String recordType = null;
        Long recordId = null;
        UserDto uploadedBy = null;

        uploadedById = mediaUploadedById( media );
        createdAt = media.getCreatedAt();
        updatedAt = media.getUpdatedAt();
        id = media.getId();
        url = media.getUrl();
        type = media.getType();
        recordType = media.getRecordType();
        recordId = media.getRecordId();
        uploadedBy = userToUserDto( media.getUploadedBy() );

        String uploadedByUsername = null;

        MediaDto mediaDto = new MediaDto( id, url, type, recordType, recordId, uploadedById, uploadedByUsername, uploadedBy, createdAt, updatedAt );

        return mediaDto;
    }

    private Long mediaUploadedById(Media media) {
        if ( media == null ) {
            return null;
        }
        User uploadedBy = media.getUploadedBy();
        if ( uploadedBy == null ) {
            return null;
        }
        Long id = uploadedBy.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String email = null;
        UserRole role = null;

        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        role = user.getRole();

        Long familyGroupId = null;

        UserDto userDto = new UserDto( id, name, email, role, familyGroupId );

        return userDto;
    }
}
