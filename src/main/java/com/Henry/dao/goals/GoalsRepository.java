package com.Henry.dao.goals;

import com.Henry.entities.Goals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalsRepository extends JpaRepository<Goals,Integer> {
}
