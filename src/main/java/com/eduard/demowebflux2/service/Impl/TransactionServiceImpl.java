package com.eduard.demowebflux2.service.Impl;

import com.eduard.demowebflux2.controller.dto.TransactionDto;
import com.eduard.demowebflux2.repository.TransactionRepository;
import com.eduard.demowebflux2.repository.entity.TransactionEntity;
import com.eduard.demowebflux2.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Override
    public Flux<TransactionDto> getAllTransactions() {
        return transactionRepository.findAll()
                .map(transaction -> new TransactionDto(
                        transaction.getId(),
                        transaction.getAmount(),
                        transaction.getCategory(),
                        transaction.getDescription(),
                        transaction.getIsIncome(),
                        transaction.getDate()
                ));
    }

    @Override
    public Mono<TransactionDto> getTransactionById(Integer id) {
        return transactionRepository.findById(id)
                .map(transaction -> new TransactionDto(
                        transaction.getId(),
                        transaction.getAmount(),
                        transaction.getCategory(),
                        transaction.getDescription(),
                        transaction.getIsIncome(),
                        transaction.getDate()
                ));
    }

    @Override
    public Mono<TransactionDto> saveTransaction(TransactionDto transactionDto) {
        return transactionRepository.save(TransactionEntity.builder()
                .amount(transactionDto.amount())
                .category(transactionDto.category())
                .description(transactionDto.description())
                .isIncome(transactionDto.isIncome())
                .date(transactionDto.date())
                .build()
        )
                .map(transaction -> new TransactionDto(
                        transaction.getId(),
                        transaction.getAmount(),
                        transaction.getCategory(),
                        transaction.getDescription(),
                        transaction.getIsIncome(),
                        transaction.getDate()
                ));
    }

    @Override
    public Mono<TransactionDto> updateTransaction(Integer id, TransactionDto transactionDto) {
        return transactionRepository.save(TransactionEntity.builder()
                        .id(id)
                        .amount(transactionDto.amount())
                        .category(transactionDto.category())
                        .description(transactionDto.description())
                        .isIncome(transactionDto.isIncome())
                        .date(transactionDto.date())
                        .build()
                )
                .map(transaction -> new TransactionDto(
                        transaction.getId(),
                        transaction.getAmount(),
                        transaction.getCategory(),
                        transaction.getDescription(),
                        transaction.getIsIncome(),
                        transaction.getDate()
                ));
    }

    @Override
    public Mono<Void> deleteTransaction(Integer id) {
        return transactionRepository.deleteById(id);
    }
}
