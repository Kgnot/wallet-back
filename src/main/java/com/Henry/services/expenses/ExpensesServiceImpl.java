package com.Henry.services.expenses;

import com.Henry.dao.expenses.ExpensesRepository;
import com.Henry.entities.Expenses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpensesServiceImpl implements ExpensesService {


    private final ExpensesRepository repository;

    @Override
    public List<Expenses> findAll() {
        return repository.findAll();
    }

    @Override
    public Expenses findById(int id) {
        Optional<Expenses> expense = repository.findById(id);
        return expense.orElse(null);
    }
    @Override
    public Expenses save(Expenses expense) {
        return repository.save(expense);
    }
}
