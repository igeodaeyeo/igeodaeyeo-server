package com.igdy.igeodaeyeo.domain.user.service;

import com.igdy.igeodaeyeo.domain.user.entity.User;
import com.igdy.igeodaeyeo.domain.user.exception.UserException;
import com.igdy.igeodaeyeo.domain.user.repository.UserRepository;
import com.igdy.igeodaeyeo.global.exception.ErrorCode;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Optional;

@Service
@Builder
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findByEmail(String email) throws Exception {
        return userRepository.findByLoginId(email).orElseThrow(() -> new AccountNotFoundException("User not found"));
    }

    @Transactional
    public String changeNickname(User user, String newNickname) throws UserException {
        Optional<User> optionalUser = userRepository.findByNickname(newNickname);
        if (optionalUser.isPresent()) {
//            throw new AlreadyUsedException("이미 사용중인 닉네임입니다.");
            throw new UserException(ErrorCode.NICKNAME_ALREADY_USED);
        }
        user.changeNickname(newNickname);
        return user.getNickname();
    }
}
