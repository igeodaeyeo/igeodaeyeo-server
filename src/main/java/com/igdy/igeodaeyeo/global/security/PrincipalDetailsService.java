package com.igdy.igeodaeyeo.global.security;

import com.igdy.igeodaeyeo.domain.user.entity.User;
import com.igdy.igeodaeyeo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByLoginId(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new PrincipalDetails(user);
    }


}
