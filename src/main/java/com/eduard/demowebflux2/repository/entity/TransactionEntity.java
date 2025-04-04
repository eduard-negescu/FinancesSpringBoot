package com.eduard.demowebflux2.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@Table(name = "transactions")
public class TransactionEntity {
    @Id
    private Integer id;
    private Double amount;
    private String category;
    private String description;
    private Boolean isIncome;
    private String date;
}
