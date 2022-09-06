package com.twoCube.auth.Token;


import com.twoCube.members.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final MemberRepository userRepository;

    @Override
    public CurrentUserDetails loadUserByUsername(String socialId) {
        return userRepository.findBySocialIdAndDeleted(socialId, false)
                .map(u -> new CurrentUserDetails(u, Collections.singleton(new SimpleGrantedAuthority("USER"))))
                .orElseThrow(() -> new UserNotFoundException(socialId));
    }
}
