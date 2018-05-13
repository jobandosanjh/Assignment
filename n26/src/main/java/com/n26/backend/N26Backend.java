package com.n26.backend;

import com.n26.statistic.model.Statistic;
import com.n26.transaction.model.Transaction;

/**
 * Contract to declare the backend operations related to transactions.
 * 
 * @author jobanpreetsingh
 *
 */
public interface N26Backend {

    /**
     * Method to add a new transaction.
     * 
     * @param transaction
     */
    void addNewTransaction(Transaction transaction);

    /**
     * Method to retrieve the statistics of transactions occurred in last 60 seconds.
     * 
     * @return {@link Statistic}
     */
    Statistic getStatistics();

}
