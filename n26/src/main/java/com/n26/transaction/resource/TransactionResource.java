package com.n26.transaction.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.n26.transaction.datatransferobject.TransactionDTO;

/**
 * Contract to declares the CRUD operations related to transaction resource.
 * 
 * @author jobanpreetsingh
 *
 */
@RequestMapping("/transactions")
public interface TransactionResource {

    /**
     * Method to add a new transaction.
     * 
     * @param transactionDTO
     * @return {@link ResponseEntity} of {@link TransactionDTO}
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    ResponseEntity<TransactionDTO> addNewTransaction(TransactionDTO transactionDTO);

}
