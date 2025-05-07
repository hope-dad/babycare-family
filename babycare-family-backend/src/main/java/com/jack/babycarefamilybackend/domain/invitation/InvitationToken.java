package com.jack.babycarefamilybackend.domain.invitation;

import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "invitation_token")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InvitationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String token;
    private String status;  // PENDING, ACCEPTED, REJECTED

    @ManyToOne(fetch = FetchType.LAZY)
    private FamilyGroup familyGroup;


}
