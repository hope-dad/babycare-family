package com.jack.babycarefamilybackend.infrastructure.web.dto.baby;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UpdateBabyRequest(
        @Size(max = 255, message = "아기 이름은 255자를 초과할 수 없습니다.") // 사이즈 제약 추가 예시
        String name,
        // 생일도 선택적 업데이트 가능
        @PastOrPresent(message = "생일은 미래 날짜일 수 없습니다.") // 과거 또는 현재 날짜만 허용 제약 추가 예시
        LocalDate birthDate,

        // 성별도 선택적 업데이트 가능
        String gender, // 성별은 enum이나 특정 값으로 제한하는게 더 안전!

        // 가족 그룹 ID도 변경 가능하게 하려면 추가 (Long)
        Long familyGroupId, // 부모 변경 기능이 있다면 필요

        String photoUrl,

        @Size(max = 3, message = "혈액형은 3자를 초과할 수 없습니다.")
        String bloodType,

        @Size(max = 1000, message = "특이사항은 1000자를 초과할 수 없습니다.")
        String characteristics,
        @Size(max = 500, message = "알레르기는 500자를 초과할 수 없습니다.")
        String allergies,

        @Size(max = 50, message = "태명은 50자를 초과할 수 없습니다.")
        String prenatalName
) {
}