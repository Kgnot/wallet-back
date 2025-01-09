package com.Henry.auth.services.RegisterBuilder.builders;

import com.Henry.auth.services.RegisterBuilder.SignInBuilder;
import com.Henry.auth.services.RegisterBuilder.UserRegister;
import com.Henry.auth.utils.RegisterRequest;
import com.Henry.entities.*;
import com.Henry.services.balances.BalancesService;
import com.Henry.services.expenses.ExpensesService;
import com.Henry.services.incomes.IncomesService;
import com.Henry.services.profiles.ProfilesService;
import com.Henry.services.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignInBuilderTotal extends SignInBuilder {

    private RegisterRequest request;
    private final UsersService usersService;
    private final ProfilesService profileService;
    private final ExpensesService expensesService;
    private final IncomesService incomesService;
    private final BalancesService balancesService;

    @Autowired
    public SignInBuilderTotal(
            UsersService usersService,
            ProfilesService profileService,
            ExpensesService expensesService,
            IncomesService incomesService,
            BalancesService balancesService
    ) {
        super.userRegister = new UserRegister();
        this.usersService = usersService;
        this.profileService = profileService;
        this.expensesService = expensesService;
        this.incomesService = incomesService;
        this.balancesService = balancesService;
    }

    @Override
    public SignInBuilder setRequest(RegisterRequest request) {
        this.request = request;
        return this;
    }

    @Override
    public SignInBuilder buildUser() {
        userRegister.setUser(
                Users.builder()
                        .email(request.getEmail())
                        .nickname(request.getNickname())
                        .password(request.getPassword())
                        .build()
        );
        userRegister.setUser(
                usersService.save(userRegister.getUser())
        );
        return this;
    }

    @Override
    public SignInBuilder buildProfile() {
        userRegister.setProfile(
                Profiles.builder()
                        .first_name(request.getFirstName())
                        .last_name(request.getLastName())
                        .user(userRegister.getUser())
                        .img(request.getImg())
                        .build()
        );
        profileService.save(userRegister.getProfile());
        return this;
    }

    @Override
    public SignInBuilder buildIncome() {
        //debo crear tantos incomes como me haya pasado, entonces:
        request.getIncomes().forEach(income -> {
            userRegister.setIncome(
                    Incomes.builder()
                            .user(userRegister.getUser())
                            .type(income.getType())
                            .build()
            );
            incomesService.save(userRegister.getIncome());
        });
        return this;
    }

    @Override
    public SignInBuilder buildExpense() {
        request.getExpenses().forEach(expense -> {
            userRegister.setExpense(
                    Expenses.builder()
                            .user(userRegister.getUser())
                            .type(expense.getType())
                            .build()
            );
            expensesService.save(userRegister.getExpense());
        });
        return this;
    }

    @Override
    public SignInBuilder buildBalance() {

        request.getBalances().forEach(balances -> {
            userRegister.setBalance(
                    Balances.builder()
                            .user(userRegister.getUser())
                            .wallet(balances.getWallet())
                            .amount(balances.getAmount())
                            .build()
            );
            balancesService.save(userRegister.getBalance());
        });

        return this;
    }

    @Override
    public Users getUser() {
        return super.userRegister.getUser();
    }
}
