package com.employee.Repository;

import com.employee.Model.Transaction;

import java.util.LinkedList;
import java.util.List;

public class TransactionRepository {
    private final List<Transaction> transactions = new LinkedList<>();

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
    public List<Transaction> getAllTransactions(){
        return transactions;
    }
}
