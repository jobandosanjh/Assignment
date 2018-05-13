package com.n26.transaction.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.Instant;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.n26.transaction.datatransferobject.TransactionDTO;
import com.n26.transaction.model.Transaction;
import com.n26.transaction.service.TransactionService;

public final class TransactionResourceImplTest {

    private TransactionDTO transactionDTO;
    private ResponseEntity<TransactionDTO> responseEntity;
    private TransactionResource transactionResource;

    @Test
    public void testAddNewTransaction() {
        givenTransactionDTO();
        givenMocks();
        whenTransactionSaveIsRequested();
        thenTransactionIsSaved();
    }

    @Test
    public void testAddNewTransactionWithOlderTransaction() {
        givenTransactionDTO();
        givenMocksForOlderTransaction();
        whenTransactionSaveIsRequested();
        thenTransactionIsNotSaved();
    }

    private void givenTransactionDTO() {
        transactionDTO = new TransactionDTO();
        transactionDTO.setAmount(100D);
        transactionDTO.setTimestamp(Instant.now().toEpochMilli());
    }

    private void givenMocks() {
        final TransactionService transactionService = mock(TransactionService.class);
        when(transactionService.addNewTransaction(any(Transaction.class))).thenReturn(true);
        transactionResource = new TransactionResourceImpl(transactionService);
    }

    private void givenMocksForOlderTransaction() {
        final TransactionService transactionService = mock(TransactionService.class);
        when(transactionService.addNewTransaction(any(Transaction.class))).thenReturn(false);
        transactionResource = new TransactionResourceImpl(transactionService);
    }

    private void whenTransactionSaveIsRequested() {
        responseEntity = transactionResource.addNewTransaction(transactionDTO);
    }

    private void thenTransactionIsSaved() {
        assertEquals(201, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }

    private void thenTransactionIsNotSaved() {
        assertEquals(204, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());
    }
}
