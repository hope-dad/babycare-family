package com.jack.babycarefamilybackend.presentation.familygroup;

import com.jack.babycarefamilybackend.application.familygroup.FamilyGroupService;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/family-groups")
@RequiredArgsConstructor
public class FamilyGroupController {
    private final FamilyGroupService familyGroupService;

    @PostMapping
    public ResponseEntity<FamilyGroup> create(@RequestBody Map<String, String> request) {
        FamilyGroup created = familyGroupService.create(request.get("name"));
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<FamilyGroup>> getAll() {
        return ResponseEntity.ok(familyGroupService.findAll());
    }
}
