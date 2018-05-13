package com.n26.transaction.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.n26.transaction.datatransferobject.TransactionDTO;
import com.n26.transaction.model.Transaction;

/**
 * Utility to map data of {@link TransactionDTO} into {@link Transaction} and vice-versa.
 * 
 * @author jobanpreetsingh
 *
 */
final class TransactionMapper {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionMapper.class);

    private TransactionMapper() {
    }

    /**
     * Method to map the data of {@link TransactionDTO} into {@link Transaction}.
     * 
     * @param transactionDTO
     * @return {@link Transaction}
     */
    static Transaction mapTransactionDTO(final TransactionDTO transactionDTO) {
        LOG.info("Entered mapTransactionDTO(transactionDTO = {})", transactionDTO);
        Assert.notNull(transactionDTO, "Transaction can not be null!");
        return new Transaction(transactionDTO.getAmount(), transactionDTO.getTimestamp());
    }
}
