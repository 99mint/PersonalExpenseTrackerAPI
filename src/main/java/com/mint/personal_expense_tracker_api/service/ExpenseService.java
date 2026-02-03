package com.mint.personal_expense_tracker_api.service;

import com.mint.personal_expense_tracker_api.entity.Expense;
import com.mint.personal_expense_tracker_api.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense addExpense(Expense expense){
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpense(){
        return expenseRepository.findAll();
    }

    public List<Expense> getExpenseByDateBetween(LocalDate date1 , LocalDate date2){
        return expenseRepository.findExpenseByDateBetween(date1 , date2);
    }

    public List<Expense> getExpenseByCategory(Expense.Category category){
        return expenseRepository.findExpenseByCategory(category);
    }

    public Expense updateExpense(Long id , Expense expenseDetails){
        Optional<Expense> existingExpense = expenseRepository.findById(id);
        if(existingExpense.isPresent()){
            Expense expense = existingExpense.get();
            expense.setAmount(expenseDetails.getAmount());
            expense.setCategory(expenseDetails.getCategory());
            expense.setDate(expenseDetails.getDate());
            expense.setDescription(expenseDetails.getDescription());
            return expenseRepository.save(expense);
        }
        return null;
    }

    public void deleteExpense(Long id){
        expenseRepository.deleteById(id);
    }

    public BigDecimal getTotalSpendingByCategory(Expense.Category category){
        BigDecimal totalSpending = BigDecimal.ZERO;
        List<Expense> spending = expenseRepository.findExpenseByCategory(category);
        for (Expense x : spending) {
            totalSpending = totalSpending.add(x.getAmount());
        }
        return totalSpending;
    }

}

