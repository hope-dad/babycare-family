package com.jack.babycarefamilybackend.application.usecase.user;

import com.jack.babycarefamilybackend.common.exception.ResourceNotFoundException;
import com.jack.babycarefamilybackend.domain.familygroup.FamilyGroup;
import com.jack.babycarefamilybackend.domain.port.repository.FamilyGroupRepository;
import com.jack.babycarefamilybackend.domain.port.repository.UserRepository;
import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.infrastructure.mapper.user.UserMapper;
import com.jack.babycarefamilybackend.infrastructure.web.dto.user.CreateUserRequest;
import com.jack.babycarefamilybackend.infrastructure.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;
    private final FamilyGroupRepository familyGroupRepository;

    @Override
    @Transactional
    public UserDto createUser(CreateUserRequest request) {
        FamilyGroup familyGroup = familyGroupRepository.findById(request.familyGroupId())
                .orElseThrow(() -> new ResourceNotFoundException("FamilyGroup", request.familyGroupId(), "Family Group With ID" + request.familyGroupId() + "not found"));
        User user = userMapper.toEntity(request, familyGroup);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getUsersByFamilyGroup(Long familyGroupId) {
        return userRepository.findByFamilyGroupId(familyGroupId)
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return userMapper.toDto(user);
    }
}