package com.Henry.services.users;

import com.Henry.dto.users.UsersDTO;
import com.Henry.entities.Users;

import java.util.List;

public interface UsersService {

    // Por terminos de mirar cosas elimnar despues
    List<UsersDTO> findAll();
    // lo que si sirve:

    Users findById(int id);
    Users save(Users user);
    Users deleteById(int id);
    Users findByEmail(String email);

}
