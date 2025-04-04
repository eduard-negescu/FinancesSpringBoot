package com.eduard.demowebflux2.service;

import com.eduard.demowebflux2.controller.dto.TransactionDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {
    Flux<TransactionDto> getAllTransactions();
    Mono<TransactionDto> getTransactionById(Integer id);
    Mono<TransactionDto> saveTransaction(TransactionDto transactionDto);
    Mono<TransactionDto> updateTransaction(Integer id, TransactionDto transactionDto);
    Mono<Void> deleteTransaction(Integer id);
}
