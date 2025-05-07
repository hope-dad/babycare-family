package com.jack.babycarefamilybackend.presentation.record;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/growth-records")
@RequiredArgsConstructor
public class GrowthRecordController {

    private final GrowthRecordService growthRecordService;

    @PostMapping
    public ResponseEntity<GrowthRecordDto> createGrowthRecord(@RequestBody CreateGrowthRecordRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(growthRecordService.createGrowthRecord(request));
    }

    @GetMapping("/baby/{babyId}")
    public ResponseEntity<List<GrowthRecordDto>> getRecordsByBaby(@PathVariable Long babyId) {
        return ResponseEntity.ok(growthRecordService.getRecordsByBabyId(babyId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<GrowthRecordDto>> getRecordsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(growthRecordService.getRecordsByUserId(userId));
    }
}
