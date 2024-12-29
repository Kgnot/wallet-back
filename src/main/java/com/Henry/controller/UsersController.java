package com.Henry.controller;

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

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable int id){
        Users user = service.findById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 404 si no se encuentra
        }
        return ResponseEntity.ok(user);
    }

}
