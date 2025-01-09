package com.Henry.mapper.any;


import com.Henry.dto.profile.ProfileDTO;
import com.Henry.dto.users.UsersDTO;
import com.Henry.entities.Profiles;
import com.Henry.entities.Users;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public UsersDTO convertUserToDTO(Users user) {
        return UsersDTO.builder()
                .email(user.getEmail())
                .nickname(user.getNickname())
                .password(user.getPassword())
                .build();
    }

    public ProfileDTO convertProfileToDTO(Profiles profiles) {
        return ProfileDTO.builder()
                .id_profile(profiles.getId_profile())
                .img(profiles.getImg())
                .user(this.convertUserToDTO(profiles.getUser()))
                .description(profiles.getDescription())
                .first_name(profiles.getFirst_name())
                .last_name(profiles.getLast_name())
                .build();

    }

}
