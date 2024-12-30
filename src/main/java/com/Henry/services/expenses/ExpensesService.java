package com.Henry.services.expenses;

import com.Henry.entities.Expenses;

import java.util.List;

public interface ExpensesService {

    List<Expenses> findAll();
    Expenses findById(int id);
    Expenses save(Expenses expense);

}
