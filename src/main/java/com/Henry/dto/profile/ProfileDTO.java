package com.Henry.dto.profile;

import com.Henry.dto.users.UsersDTO;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileDTO {
    private int id_profile;
    private UsersDTO user;
    private String first_name;
    private String last_name;
    private String img;
    private String description;
}
