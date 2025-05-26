package com.jack.babycarefamilybackend.domain.invitation;

import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "invitation_token")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InvitationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String token;
    private InvitationStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private FamilyGroup familyGroup;


}
