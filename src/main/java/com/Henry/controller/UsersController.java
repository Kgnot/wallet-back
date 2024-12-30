package com.Henry.controller;
// Este controlador tiene como función : [tengo que ver si se le da uso o no, puede que para algo de análisis de datos]
//Tendria que manejar roles, pero por ahora no, sería para luego, de igual forma se puede modificar facilmente
// tendra un metodo que será para probar si la autenticacion sirve

import com.Henry.dto.users.UsersDTO;
import com.Henry.entities.Users;
import com.Henry.services.users.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService service;

    @GetMapping
    public List<UsersDTO> getUsers(){
        return service.findAll();
    }


}
