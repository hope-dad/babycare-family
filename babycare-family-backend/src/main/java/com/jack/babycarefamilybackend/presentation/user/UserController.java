package com.jack.babycarefamilybackend.presentation.user;

import com.jack.babycarefamilybackend.application.user.UserService;
import com.jack.babycarefamilybackend.dto.user.CreateUserRequest;
import com.jack.babycarefamilybackend.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
    }

    @GetMapping("/family/{familyGroupId}")
    public ResponseEntity<List<UserDto>> getUsersByFamilyGroup(@PathVariable Long familyGroupId) {
        return ResponseEntity.ok(userService.getUsersByFamilyGroup(familyGroupId));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }
}