package com.Henry.auth.services.RegisterBuilder;

import com.Henry.entities.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegister {
    private Users user;
    private Profiles profile;
    private Incomes income;
    private Expenses expense;
    private Balances balance;

}
