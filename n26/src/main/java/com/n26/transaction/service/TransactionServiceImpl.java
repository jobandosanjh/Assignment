package com.n26.transaction.service;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.n26.backend.N26Backend;
import com.n26.transaction.model.Transaction;

/**
 * Entity to handle business operations related to transaction.
 * 
 * @author jobanpreetsingh
 *
 */
@Service
@Lazy
public class TransactionServiceImpl implements TransactionService {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionServiceImpl.class);

    private final N26Backend backend;

    @Autowired
    @Lazy
    public TransactionServiceImpl(final N26Backend backend) {
        this.backend = backend;
    }

    @Override
    public boolean addNewTransaction(final Transaction transaction) {
        LOG.info("Entered addNewTransaction(transaction = {})", transaction);
        final boolean isSaved = Instant.ofEpochMilli(transaction.getTimestamp())
                .isAfter(Instant.now().minusSeconds(60));
        if (isSaved) {
            backend.addNewTransaction(transaction);
        }
        return isSaved;
    }

}
