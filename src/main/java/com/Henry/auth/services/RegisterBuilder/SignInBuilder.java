package com.Henry.auth.services.RegisterBuilder;

import com.Henry.auth.utils.RegisterRequest;
import com.Henry.entities.Users;


public abstract class SignInBuilder {
    protected UserRegister userRegister;

    public abstract SignInBuilder setRequest(RegisterRequest re);

    public abstract SignInBuilder buildUser();

    public abstract SignInBuilder buildProfile();

    public abstract SignInBuilder buildIncome();

    public abstract SignInBuilder buildExpense();

    public abstract SignInBuilder buildBalance();

    public abstract Users getUser();

}
