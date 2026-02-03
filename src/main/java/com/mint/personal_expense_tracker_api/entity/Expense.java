package com.mint.personal_expense_tracker_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount;

    private String description;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Category category;

    public enum Category{
        Food,
        Travel,
        Junk,
        Household,
        Apparel,
        SkinCare,
        HairCare,
        Education,
        Devices,
        Fitness
    }
}
