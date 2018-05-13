package com.n26.transaction.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.time.Instant;

import org.junit.Test;

import com.n26.backend.N26Backend;
import com.n26.transaction.model.Transaction;

/**
 * Test class for {@link TransactionServiceImpl}.
 * 
 * @author jobanpreetsingh
 *
 */
public final class TransactionServiceImplTest {

    private Transaction transaction;
    private boolean result;
    private TransactionService transactionService;

    @Test
    public void testAddNewTransaction() {
        givenNewTransaction();
        givenMocks();
        whenTransactionAddingIsRequested();
        thenTransactionIsAdded();
    }

    @Test
    public void testAddNewTransactionOlderThan60Seconds() {
        givenNewTransactionWithTimestampOlderThan60Seconds();
        givenMocks();
        whenTransactionAddingIsRequested();
        thenTransactionIsNotAdded();
    }

    private void givenNewTransaction() {
        transaction = new Transaction(100, Instant.now().toEpochMilli());
    }

    private void givenNewTransactionWithTimestampOlderThan60Seconds() {
        transaction = new Transaction(200, Instant.now().minusSeconds(60).toEpochMilli());
    }

    private void givenMocks() {
        final N26Backend n26Backend = mock(N26Backend.class);
        doNothing().when(n26Backend).addNewTransaction(any(Transaction.class));
        transactionService = new TransactionServiceImpl(n26Backend);
    }

    private void whenTransactionAddingIsRequested() {
        result = transactionService.addNewTransaction(transaction);
    }

    private void thenTransactionIsAdded() {
        assertTrue(result);
    }

    private void thenTransactionIsNotAdded() {
        assertFalse(result);
    }

}