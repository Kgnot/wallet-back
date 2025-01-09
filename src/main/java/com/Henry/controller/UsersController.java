package com.Henry.controller;

import com.Henry.dto.users.UsersDTO;
import com.Henry.services.users.UsersService;
import lombok.RequiredArgsConstructor;
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
