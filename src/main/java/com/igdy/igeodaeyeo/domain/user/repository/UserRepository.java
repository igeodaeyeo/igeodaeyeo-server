package com.igdy.igeodaeyeo.domain.user.repository;

import com.igdy.igeodaeyeo.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByLoginId(String email);
    Optional<User> findByNickname(String nickname);
    Optional<User> findByUserKey(String userKey);
}
