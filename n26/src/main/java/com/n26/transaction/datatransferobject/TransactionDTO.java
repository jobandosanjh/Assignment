package com.n26.transaction.datatransferobject;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Data transfer object for handling data related to a particular transaction. This object is mainly used to transmit
 * data between client and server.
 * 
 * @author jobanpreetsingh
 *
 */
@JsonInclude(NON_NULL)
public class TransactionDTO {

    @NotNull(message = "Amount can not be null!")
    private Double amount;

    @NotNull(message = "Timestamp can not be null!")
    private Long timestamp;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(final Double amount) {
        this.amount = amount;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final Long timestamp) {
        this.timestamp = timestamp;
    }

}
