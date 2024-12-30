package com.Henry.auth.services.RegisterBuilder;


import com.Henry.auth.services.RegisterBuilder.builders.SignInBuilderTotal;
import com.Henry.auth.utils.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Register {

    private final SignInBuilder signInBuilder;

   public void register(RegisterRequest request){
       signInBuilder.setRequest(request)
               .buildUser()
               .buildProfile()
               .buildIncome()
               .buildExpense()
               .buildBalance();
   }

}
