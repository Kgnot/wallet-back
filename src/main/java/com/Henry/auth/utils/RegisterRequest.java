package com.Henry.auth.utils;


import com.Henry.entities.Expenses;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    String nickname;
    String email;
    String password;
    String firstName;
    String lastName;
    String description;
    // También quiere añadir lo que son los Expenses e Incomes:
    List<Expenses> expenses;
}
