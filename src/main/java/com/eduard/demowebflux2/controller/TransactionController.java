package com.eduard.demowebflux2.controller;

import com.eduard.demowebflux2.controller.dto.TransactionDto;
import com.eduard.demowebflux2.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    Flux<TransactionDto> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    Mono<TransactionDto> getTransactionById(@PathVariable("id") Integer id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping
    Mono<TransactionDto> saveTransaction(@RequestBody TransactionDto transactionDto) {
        return transactionService.saveTransaction(transactionDto);
    }

    @PutMapping("/{id}")
    Mono<TransactionDto> updateTransaction(@PathVariable("id") Integer id, @RequestBody TransactionDto transactionDto) {
        return transactionService.updateTransaction(id, transactionDto);
    }

    @DeleteMapping("/{id}")
    Mono<Void> deleteTransaction(@PathVariable("id") Integer id) {
        return transactionService.deleteTransaction(id);
    }

}
