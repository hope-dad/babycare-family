package com.jack.babycarefamilybackend.domain.media;

import com.jack.babycarefamilybackend.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "media")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    private String type;  // IMAGE, VIDEO

    private String recordType;
    private Long recordId;

    @ManyToOne(fetch = FetchType.LAZY)
    private User uploadedBy;


}
