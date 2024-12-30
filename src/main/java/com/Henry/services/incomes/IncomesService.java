package com.Henry.services.incomes;

import com.Henry.entities.Incomes;

import java.util.List;

public interface IncomesService {

    List<Incomes> findAll();
    Incomes findById(int id);
    Incomes save(Incomes income);

}
