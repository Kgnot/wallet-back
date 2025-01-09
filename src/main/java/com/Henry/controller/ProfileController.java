package com.Henry.controller;
//este será para modificar el perfil del usuario

import com.Henry.dto.profile.ProfileDTO;
import com.Henry.entities.Profiles;
import com.Henry.services.profiles.ProfilesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfilesService service;
    @GetMapping
    public ResponseEntity<ProfileDTO> getProfile(Principal principal) {
        String email = principal.getName();
        ProfileDTO profile = service.findByUser(email);
        return ResponseEntity.ok(profile);
    }


}
