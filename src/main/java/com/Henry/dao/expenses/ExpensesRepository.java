package com.Henry.dao.expenses;

import com.Henry.entities.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesRepository extends JpaRepository<Expenses,Integer> {
}
