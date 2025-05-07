package com.jack.babycarefamilybackend.application.user;

import com.jack.babycarefamilybackend.application.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroupRepository;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import com.jack.babycarefamilybackend.dto.user.CreateUserRequest;
import com.jack.babycarefamilybackend.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;
    private final FamilyGroupRepository familyGroupRepository;

    @Transactional
    public UserDto createUser(CreateUserRequest request) {
        FamilyGroup familyGroup = familyGroupRepository.findById(request.familyGroupId())
                .orElseThrow(() -> new ResourceNotFoundException("FamilyGroup", request.familyGroupId(), "Family Group With ID" + request.familyGroupId() + "not found"));
        User user = userMapper.toEntity(request, familyGroup);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Transactional(readOnly = true)
    public List<UserDto> getUsersByFamilyGroup(Long familyGroupId) {
        return userRepository.findByFamilyGroupId(familyGroupId)
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return userMapper.toDto(user);
    }
}