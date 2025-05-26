package com.jack.babycarefamilybackend.domain.media;

import com.jack.babycarefamilybackend.domain.common.BaseTimeEntity; // BaseTimeEntity 임포트
import com.jack.babycarefamilybackend.domain.user.User; // User 엔티티 임포트
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank; // @NotBlank 임포트
import jakarta.validation.constraints.NotNull; // @NotNull 임포트
import lombok.*;

import java.time.Instant; // 논리적 삭제 시간 기록용 임포트

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
@Table(name = "media")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA를 위한 기본 생성자
public class Media extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank // URL 필수
    @Column(nullable = false)
    private String url; // 업로드된 파일의 URL

    @NotNull
    @Enumerated(EnumType.STRING) // Enum 값을 DB에 문자열로 저장
    @Column(nullable = false)
    private MediaStatus type; // 미디어 타입 (IMAGE, VIDEO 등)

    @NotBlank // 연결될 기록 타입 필수
    @Column(nullable = false)
    private String recordType; // 어떤 기록에 연결된 미디어인지 (예: "BabyRecord", "FeedingRecord" 등 엔티티 이름)

    @NotNull // 연결된 기록 ID 필수
    @Column(nullable = false)
    private Long recordId; // 연결된 기록의 ID

    @NotNull // 업로드 유저 필수
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uploaded_by_user_id", nullable = false) // 외래 키 컬럼 이름 명시 및 null 불가 설정
    @ToString.Exclude // 무한 순환 참조 방지
    private User uploadedBy; // 누가 업로드했는지 유저

    // ✨ 논리적 삭제 (Soft Delete) 관련 필드 (필요하다면 추가) ✨
    @Column(nullable = false)
    private boolean isActive = true; // 미디어 정보의 활성 상태 (true: 활성, false: 삭제됨)

    private Instant deletedAt; // 미디어 정보가 논리적으로 삭제된 시점

    // --- Static Factory Method (객체 생성) ---
    // Constructor 대신 이 메서드를 사용해서 Media 객체를 생성합니다.
    public static Media create(String url, MediaStatus type, String recordType, Long recordId, User uploadedBy) {
        // ✨ 생성 시점에 필요한 유효성 검사나 불변식 체크 로직 추가 가능 ✨
        if (url == null || url.trim().isEmpty()) throw new IllegalArgumentException("URL은 필수입니다.");
        if (type == null) throw new IllegalArgumentException("미디어 타입은 필수입니다.");
        if (recordType == null || recordType.trim().isEmpty()) throw new IllegalArgumentException("기록 타입은 필수입니다.");
        if (recordId == null) throw new IllegalArgumentException("기록 ID는 필수입니다.");
        if (uploadedBy == null) throw new IllegalArgumentException("업로드 유저는 필수입니다.");

        Media media = new Media(); // protected 기본 생성자 호출
        media.url = url;
        media.type = type;
        media.recordType = recordType;
        media.recordId = recordId;
        media.uploadedBy = uploadedBy;
        // 논리적 삭제 필드는 기본값 설정
        media.isActive = true;
        media.deletedAt = null;
        // BaseTimeEntity 필드 (createdAt, updatedAt)는 Auditing으로 자동 채워짐

        return media;
    }

    // --- 비즈니스 로직 메서드 (도메인 행위) ---
    // 예: 미디어 정보 업데이트 (URL 변경 등)
    // public void updateUrl(@NotBlank String newUrl) {
    //     if (newUrl == null || newUrl.trim().isEmpty()) throw new IllegalArgumentException("새 URL은 필수입니다.");
    //     this.url = newUrl;
    // }

    // 논리적 삭제 관련 메서드 (필요하다면 추가)
    public void softDelete() {
        if (!this.isActive) return; // 이미 삭제됨
        this.isActive = false;
        this.deletedAt = Instant.now();
    }

    public void restore() {
        if (this.isActive) return; // 이미 활성 상태
        this.isActive = true;
        this.deletedAt = null;
    }


}
