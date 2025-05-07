package com.jack.babycarefamilybackend.application.user;

import com.jack.babycarefamilybackend.domain.user.User;
import com.jack.babycarefamilybackend.domain.user.UserRepository;
import com.jack.babycarefamilybackend.dto.user.CreateUserRequest;
import com.jack.babycarefamilybackend.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto create(CreateUserRequest request){
        User save = userRepository.save(userMapper.toEntity(request));
        return userMapper.toDto(save);
    }

    public List<UserDto> findAll(){
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }
}
