package com.Henry.auth.services;

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

    private final UsersService usersService;
    private final ProfilesService profilesService;
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;
    private final AuthenticationManager authenticationManager;

    //Aquí estámos creando el usuario, entonces:
    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = jwtService.getToken(userDetails);

        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        // NO OLVIDAR AÑADDIR QUE SI NO SE CRA EL PERFIL ELIMINAR EL USUARIO, MANEJAR ESE ERROR :CCC
        Users user = Users.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .nickname(request.getNickname())
                .build();

        user = usersService.save(user);

        Profiles profile = Profiles.builder()
                .first_name(request.getFirstName())
                .last_name(request.getLastName())
                .id_user(user)
                .build();
        profilesService.save(profile);

        // Parte adicional que no está en el video pero lo hago para colocarlo
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());

        return AuthResponse.builder()
                .token(jwtService.getToken(userDetails))
                .build();

    }
}
