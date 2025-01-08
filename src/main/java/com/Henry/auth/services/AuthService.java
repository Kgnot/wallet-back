package com.Henry.auth.services;

import com.Henry.auth.services.RegisterBuilder.Register;
import com.Henry.auth.utils.AuthResponse;
import com.Henry.auth.utils.LoginRequest;
import com.Henry.auth.utils.RegisterRequest;
import com.Henry.entities.Profiles;
import com.Henry.entities.Users;
import com.Henry.security.services.UserDetailsServiceImpl;
import com.Henry.services.profiles.ProfilesService;
import com.Henry.services.users.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final Register register;
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;
    private final AuthenticationManager authenticationManager;

    //Aquí estámos creando el usuario, entonces:
    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        System.out.println(userDetails);
        String token = jwtService.getToken(userDetails);

        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        register.register(request);
        String email = register.getUser().getEmail();
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        System.out.println("de parte de autservice register: "+userDetails);
        return AuthResponse.builder()
                .token(jwtService.getToken(userDetails))
                .build();
    }
}
