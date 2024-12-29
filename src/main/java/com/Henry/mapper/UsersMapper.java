package com.Henry.mapper;

import com.Henry.entities.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsersMapper { // usamos como un singleton

    private final BCryptPasswordEncoder encoder;

    private UsersMapper() {
        encoder = new BCryptPasswordEncoder();
    }

    public static UsersMapper getInstance() {
        return new UsersMapper();
    }

    //Aquí podemos usar un UsersRequestDTO para validar si la contraseña está bien puesta o no, pero lo podemos hacer también del frontend
    //dejaré lo que es como serpia la clase más abajo
    public Users toEntity(Users user) {
        return Users.builder()
                .email(user.getEmail())
                .nickname(user.getNickname())
                .password(encoder.encode(user.getPassword()))
                .build();

    }
}