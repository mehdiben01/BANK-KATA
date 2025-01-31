package com.employee.Model;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private final LocalDate transactionDate;
    private final int amount;
    private final int balance;

    public Transaction(LocalDate transactionDate, int amount, int balance) {
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.balance = balance;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount && balance == that.balance && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionDate, amount, balance);
    }
}
