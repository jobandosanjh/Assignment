package com.n26.transaction.resource;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.n26.transaction.datatransferobject.TransactionDTO;
import com.n26.transaction.service.TransactionService;

/**
 * Entity to handle CRUD operations related to transaction resource.
 * 
 * @author jobanpreetsingh
 *
 */
@RestController
public class TransactionResourceImpl implements TransactionResource {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionResourceImpl.class);

    private final TransactionService transactionService;

    @Autowired
    @Lazy
    public TransactionResourceImpl(final TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public ResponseEntity<TransactionDTO> addNewTransaction(@Valid @RequestBody final TransactionDTO transactionDTO) {
        LOG.info("Entered addNewTransaction(transactionDTO = {})", transactionDTO);
        final boolean result = transactionService
                .addNewTransaction(TransactionMapper.mapTransactionDTO(transactionDTO));
        return new ResponseEntity<>(new TransactionDTO(), result ? CREATED : NO_CONTENT);
    }

}
