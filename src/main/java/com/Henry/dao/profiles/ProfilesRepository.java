package com.Henry.dao.profiles;

import com.Henry.entities.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfilesRepository extends JpaRepository<Profiles,Integer> {

    Optional<Profiles> findByUser_Email(String email);

}
