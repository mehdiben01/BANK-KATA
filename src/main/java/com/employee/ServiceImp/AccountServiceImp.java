package com.employee.ServiceImp;


import com.employee.Model.Transaction;
import com.employee.Repository.TransactionRepository;
import com.employee.Service.AccountService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountServiceImp implements AccountService {
    private final TransactionRepository transactionRepository;
    private int balance = 0;

    public AccountServiceImp(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void deposit(int amount) {
        balance += amount;
        transactionRepository.addTransaction(new Transaction(LocalDate.now(),amount,balance));
    }

    @Override
    public void withdraw(int amount) {
        balance -= amount;
        transactionRepository.addTransaction(new Transaction(LocalDate.now(),-amount,balance));
    }

    @Override
    public void printStatement() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<Transaction> transactions = transactionRepository.getAllTransactions();
        Collections.reverse(transactions);
        System.out.print("Date         || Amount   || Balance\n");
        for(Transaction transaction : transactions){
            String formattedDate = transaction.getTransactionDate().format(formatter);
            System.out.printf("%s   ||%6d    || %6d%n",
                    formattedDate,
                    transaction.getAmount(),
                    transaction.getBalance()
            );
        }
    }
}
