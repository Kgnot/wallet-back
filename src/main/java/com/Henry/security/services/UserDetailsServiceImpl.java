package com.Henry.security.services;

import com.Henry.dao.users.UsersRepository;
import com.Henry.entities.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UsersRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final Users user = repository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Unknown user with email: " + email);
        }

        return User.withUsername(user.getEmail())
                .password(user.getPassword())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
