package com.mint.personal_expense_tracker_api.repository;

import com.mint.personal_expense_tracker_api.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense , Long> {
    // Get expenses by category
    List<Expense> findExpenseByCategory(Expense.Category category);

    // Get expenses by date range
    List<Expense> findExpenseByDateBetween(LocalDate dateAfter, LocalDate dateBefore);

}
