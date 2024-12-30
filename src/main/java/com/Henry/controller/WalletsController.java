package com.Henry.controller;

//Este controlador será unicamente para poder mostrar las wallets ya sean totales o por id, por lo que será publica :3

import com.Henry.entities.Wallets;
import com.Henry.services.wallets.WalletsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletsController {

    private final WalletsService service;


    public List<Wallets> findAll(){
        return service.findAll();
    }

}
