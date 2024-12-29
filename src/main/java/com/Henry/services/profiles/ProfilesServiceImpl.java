package com.Henry.services.profiles;

import com.Henry.dao.profiles.ProfilesRepository;
import com.Henry.entities.Profiles;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfilesServiceImpl implements ProfilesService {

    private final ProfilesRepository repository;

    @Override
    public void save(Profiles profile) {
        repository.save(profile);
    }
}
