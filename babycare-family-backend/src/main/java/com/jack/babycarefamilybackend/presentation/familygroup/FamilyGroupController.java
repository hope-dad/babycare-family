package com.jack.babycarefamilybackend.presentation.familygroup;

import com.jack.babycarefamilybackend.application.familygroup.FamilyGroupService;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.dto.familygroup.CreateFamilyGroupRequest;
import com.jack.babycarefamilybackend.dto.familygroup.FamilyGroupDto;
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
    public ResponseEntity<FamilyGroupDto> createFamilyGroup(@RequestBody CreateFamilyGroupRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(familyGroupService.createFamilyGroup(request));
    }

    @GetMapping
    public ResponseEntity<List<FamilyGroupDto>> getAllFamilyGroups() {
        return ResponseEntity.ok(familyGroupService.getAllFamilyGroups());
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<FamilyGroupDto> getFamilyGroupById(@PathVariable Long groupId) {
        return ResponseEntity.ok(familyGroupService.getFamilyGroupById(groupId));
    }
}
