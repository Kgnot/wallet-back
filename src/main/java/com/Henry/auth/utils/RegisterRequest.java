package com.Henry.auth.utils;


import com.Henry.entities.Balances;
import com.Henry.entities.Expenses;
import com.Henry.entities.Incomes;
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
    String img;
    // También quiere añadir lo que son los Expenses, incomes y balances:
    List<Expenses> expenses;
    List<Incomes> incomes;
    List<Balances> balances;
}
