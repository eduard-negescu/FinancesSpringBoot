package com.eduard.demowebflux2.repository;

import com.eduard.demowebflux2.repository.entity.TransactionEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface TransactionRepository extends R2dbcRepository<TransactionEntity, Integer> {
}
