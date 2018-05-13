package com.n26.transaction.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.Instant;

import org.junit.Test;

import com.n26.transaction.datatransferobject.TransactionDTO;
import com.n26.transaction.model.Transaction;

/**
 * Test class for {@link TransactionMapper}.
 * 
 * @author jobanpreetsingh
 *
 */
public final class TransactionMapperTest {

    private Transaction transaction;
    private TransactionDTO transactionDTO;

    @Test
    public void testMapTransactionDTO() {
        givenTransactionDTO();
        whenTransactionIsRequested();
        thenTransactionDTOIsMappedToTransaction();
    }

    private void givenTransactionDTO() {
        transactionDTO = new TransactionDTO();
        transactionDTO.setAmount(100D);
        transactionDTO.setTimestamp(Instant.now().toEpochMilli());
    }

    private void whenTransactionIsRequested() {
        transaction = TransactionMapper.mapTransactionDTO(transactionDTO);
    }

    private void thenTransactionDTOIsMappedToTransaction() {
        assertNotNull(transaction);
        assertEquals(transactionDTO.getAmount(), Double.valueOf(transaction.getAmount()));
        assertEquals(transactionDTO.getTimestamp(), Long.valueOf(transaction.getTimestamp()));
    }

}
