package com.mint.personal_expense_tracker_api.controller;

import com.mint.personal_expense_tracker_api.entity.Expense;
import com.mint.personal_expense_tracker_api.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense){
        return expenseService.addExpense(expense);
    }

    @GetMapping
    public List<Expense> getAllExpense(){
        return expenseService.getAllExpense();
    }

    @GetMapping("/date-range/{startDate}/{endDate}")
    public List<Expense> getAllExpenseByDateBetween(@PathVariable LocalDate startDate , @PathVariable LocalDate endDate){
        return expenseService.getExpenseByDateBetween(startDate , endDate);
    }

    @GetMapping("/category/{category}")
    public List<Expense> getAllExpenseByCategory(@PathVariable Expense.Category category){
        return expenseService.getExpenseByCategory(category);
    }

    @GetMapping("/category/{category}/total")
    public BigDecimal getTotalSpendingByCategory(@PathVariable Expense.Category category){
        return expenseService.getTotalSpendingByCategory(category);
    }

    @PatchMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expenseDetails) {
        return expenseService.updateExpense(id, expenseDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }
}
