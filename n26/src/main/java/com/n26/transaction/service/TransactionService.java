package com.n26.transaction.service;

import com.n26.transaction.model.Transaction;

/**
 * Contract to declare business operations related to transaction.
 * 
 * @author jobanpreetsingh
 *
 */
public interface TransactionService {

    /**
     * Method to add a new transaction.
     * 
     * @param transaction
     * @return true if the transaction is not older than 60 seconds otherwise false
     */
    boolean addNewTransaction(Transaction transaction);

}
