package com.jack.babycarefamilybackend.presentation.record;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vaccination-records")
@RequiredArgsConstructor
public class VaccinationRecordController {

    private final VaccinationRecordService vaccinationRecordService;

    @PostMapping
    public ResponseEntity<VaccinationRecordDto> createRecord(@RequestBody CreateVaccinationRecordRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vaccinationRecordService.createVaccinationRecord(request));
    }

    @GetMapping("/baby/{babyId}")
    public ResponseEntity<List<VaccinationRecordDto>> getRecordsByBaby(@PathVariable Long babyId) {
        return ResponseEntity.ok(vaccinationRecordService.getRecordsByBabyId(babyId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<VaccinationRecordDto>> getRecordsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(vaccinationRecordService.getRecordsByUserId(userId));
    }
}
