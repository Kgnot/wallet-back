package com.Henry.dto.users;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersDTO {
    private int id;
    private String email;
    private String nickname;
    private String password;
}
