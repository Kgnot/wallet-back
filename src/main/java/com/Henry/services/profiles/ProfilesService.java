package com.Henry.services.profiles;

import com.Henry.dto.profile.ProfileDTO;
import com.Henry.entities.Profiles;

public interface ProfilesService {

    void save(Profiles profile);
    ProfileDTO findByUser(String email);
}
