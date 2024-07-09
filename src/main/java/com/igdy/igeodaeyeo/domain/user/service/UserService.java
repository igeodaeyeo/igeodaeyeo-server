package com.igdy.igeodaeyeo.domain.user.service;

import com.igdy.igeodaeyeo.domain.user.dto.UserDto;
import com.igdy.igeodaeyeo.domain.user.entity.User;
import com.igdy.igeodaeyeo.domain.user.exception.UserException;
import com.igdy.igeodaeyeo.domain.user.repository.UserRepository;
import com.igdy.igeodaeyeo.global.exception.ErrorCode;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Builder
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findByUserKey(String userKey) {
        return userRepository.findByUserKey(userKey)
                .orElseThrow(() -> new UserException(ErrorCode.USER_NOT_FOUND));
    }

    @Transactional
    public String changeNickname(User user, String newNickname) throws UserException {
        Optional<User> optionalUser = userRepository.findByNickname(newNickname);
        if (optionalUser.isPresent()) {
            throw new UserException(ErrorCode.NICKNAME_ALREADY_USED);
        }
        user.changeNickname(newNickname);
        return user.getNickname();
    }

    public UserDto getUserInfo(String userKey) {
        User user = userRepository.findByUserKey(userKey)
                .orElseThrow(() -> new UserException(ErrorCode.USER_NOT_FOUND));

        return UserDto.fromEntity(user);
    }

}
