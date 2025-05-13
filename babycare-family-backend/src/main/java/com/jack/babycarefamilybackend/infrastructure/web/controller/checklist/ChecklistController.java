package com.jack.babycarefamilybackend.infrastructure.web.controller.checklist;

import com.jack.babycarefamilybackend.application.usecase.checklist.ChecklistService;
import com.jack.babycarefamilybackend.infrastructure.web.dto.checklist.ChecklistDto;
import com.jack.babycarefamilybackend.infrastructure.web.dto.checklist.CreateChecklistRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checklists")
@RequiredArgsConstructor
public class ChecklistController {

    private final ChecklistService checklistService;

    @PostMapping
    public ResponseEntity<ChecklistDto> create(@RequestBody CreateChecklistRequest request) {
        return ResponseEntity.ok(checklistService.create(request));
    }

    @GetMapping("/baby/{babyId}")
    public ResponseEntity<List<ChecklistDto>> getByBaby(@PathVariable Long babyId) {
        return ResponseEntity.ok(checklistService.getByBaby(babyId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ChecklistDto>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(checklistService.getByUser(userId));
    }

    @PatchMapping("/{checklistId}/complete")
    public ResponseEntity<Void> markComplete(@PathVariable Long checklistId) {
        checklistService.markCompleted(checklistId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{checklistId}/incomplete")
    public ResponseEntity<Void> markIncomplete(@PathVariable Long checklistId) {
        checklistService.markIncomplete(checklistId);
        return ResponseEntity.ok().build();
    }
}

