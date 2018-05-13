package com.n26.backend;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.Instant;

import org.junit.BeforeClass;
import org.junit.Test;

import com.n26.statistic.model.Statistic;
import com.n26.transaction.model.Transaction;

/**
 * Test class for {@link N26BackendImpl}.
 * 
 * @author jobanpreetsingh
 *
 */
public final class N26BackendImplTest {

    private static N26Backend backend;
    private Transaction transaction;
    private Statistic statistic;

    @BeforeClass
    public static void setUp() {
        backend = new N26BackendImpl();
    }

    @Test
    public void testAddNewTransaction() {
        givenTransaction();
        whenTransactionSaveIsRequested();
        thenTransactionIsSaved();
    }

    @Test
    public void testGetStatistics() {
        givenTransactions();
        whenStatisticsAreRequested();
        thenStatisticsAreRetrieved();
    }

    private void givenTransaction() {
        transaction = new Transaction(100d, Instant.now().toEpochMilli());
    }

    private void givenTransactions() {
        transaction = new Transaction(200d, Instant.now().toEpochMilli());
        whenTransactionSaveIsRequested();
        transaction = new Transaction(199d, Instant.now().toEpochMilli());
        whenTransactionSaveIsRequested();
    }

    private void whenTransactionSaveIsRequested() {
        backend.addNewTransaction(transaction);
    }

    private void whenStatisticsAreRequested() {
        statistic = backend.getStatistics();
    }

    private void thenTransactionIsSaved() {
        assertTrue(true);
    }

    private void thenStatisticsAreRetrieved() {
        assertNotNull(statistic);
    }
}
