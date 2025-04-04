package com.eduard.demowebflux2.controller.dto;

public record TransactionDto(
        Integer id,
        Double amount,
        String category,
        String description,
        Boolean isIncome,
        String date
) {
}
