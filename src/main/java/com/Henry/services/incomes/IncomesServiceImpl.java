package com.Henry.services.incomes;

import com.Henry.dao.incomes.IncomesRepository;
import com.Henry.entities.Incomes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IncomesServiceImpl implements IncomesService{

    private final IncomesRepository repository;

    @Override
    public List<Incomes> findAll() {
        return repository.findAll();
    }

    @Override
    public Incomes findById(int id) {
        Optional<Incomes> income = repository.findById(id);
        return income.orElse(null);
    }

    @Override
    public Incomes save(Incomes income) {
        return repository.save(income);
    }
}
