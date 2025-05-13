package com.jack.babycarefamilybackend.domain.familygroup;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "family_group")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FamilyGroup {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime createdAt;


    public FamilyGroup(String name) {
        this.name = name;
    }
}
