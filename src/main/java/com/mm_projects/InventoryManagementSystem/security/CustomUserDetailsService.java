package com.mm_projects.InventoryManagementSystem.security;

import com.mm_projects.InventoryManagementSystem.exception.NotFoundException;
import com.mm_projects.InventoryManagementSystem.model.User;
import com.mm_projects.InventoryManagementSystem.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(@NonNull String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username).orElseThrow(
                ()-> new NotFoundException("User not found!")
        );

        return AuthUser.builder()
                .user(user)
                .build();
    }
}
