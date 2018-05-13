package com.n26.transaction.model;

/**
 * Entity to hold data related to a particular transaction. This model is mainly used for the communication between
 * different layers of the application.
 * 
 * @author jobanpreetsingh
 *
 */
public class Transaction {

    private final double amount;
    private final long timestamp;

    public Transaction(final double amount, final long timestamp) {
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Transaction [amount=" + amount + ", timestamp=" + timestamp + "]";
    }

}
