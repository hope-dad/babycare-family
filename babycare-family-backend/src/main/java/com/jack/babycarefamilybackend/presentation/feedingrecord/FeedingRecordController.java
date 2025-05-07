package com.jack.babycarefamilybackend.presentation.feedingrecord;

import com.jack.babycarefamilybackend.application.feedingrecord.FeedingRecordService;
import com.jack.babycarefamilybackend.dto.feedingrecord.CreateFeedingRecordRequest;
import com.jack.babycarefamilybackend.dto.feedingrecord.FeedingRecordDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feeding")
@RequiredArgsConstructor
public class FeedingRecordController {
    private final FeedingRecordService feedingRecordService;

    @PostMapping
    public ResponseEntity<FeedingRecordDto> create(@RequestBody CreateFeedingRecordRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                feedingRecordService.create(request)
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FeedingRecordDto>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(feedingRecordService.findAllByUser(userId));
    }
}
