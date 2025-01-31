package com.employee.ServiceImp;


import com.employee.Model.Transaction;
import com.employee.Repository.TransactionRepository;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class AccountTest {
    @Test
    public void testPrintStatement() {
        // Arrange
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        AccountServiceImp accountServiceImp = new AccountServiceImp(transactionRepository);

        List<Transaction> mockedTransactions = new ArrayList<>();
        mockedTransactions.add(new Transaction(LocalDate.of(2012, 1, 10), 1000, 1000));
        mockedTransactions.add(new Transaction(LocalDate.of(2012, 1, 13), 2000, 3000));
        mockedTransactions.add(new Transaction(LocalDate.of(2012, 1, 14), -500, 2500));

        when(transactionRepository.getAllTransactions()).thenReturn(mockedTransactions);

        accountServiceImp.deposit(1000);
        accountServiceImp.deposit(2000);
        accountServiceImp.withdraw(500);

        accountServiceImp.printStatement();

        verify(transactionRepository).getAllTransactions();
    }
}