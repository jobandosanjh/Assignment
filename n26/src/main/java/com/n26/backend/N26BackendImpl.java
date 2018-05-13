package com.n26.backend;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.n26.statistic.model.Statistic;
import com.n26.transaction.model.Transaction;

/**
 * Entity to handle backend operations related to transactions.
 * 
 * @author jobanpreetsingh
 *
 */
@Repository
@Lazy
public class N26BackendImpl implements N26Backend {

    private static final Logger LOG = LoggerFactory.getLogger(N26BackendImpl.class);

    private Object lock = new Object();
    private Collection<Transaction> transactions;
    private Statistic statistic;

    public N26BackendImpl() {
        this.transactions = new ArrayList<>();
        this.statistic = new Statistic();
        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new TransactionManager(), 1, 1, MILLISECONDS);
    }

    @Override
    public void addNewTransaction(final Transaction transaction) {
        LOG.info("Entered addNewTransaction(transaction = {})" + transaction);
        synchronized (lock) {
            transactions.add(transaction);
        }
    }

    @Override
    public Statistic getStatistics() {
        LOG.info("Entered getStatistics()");
        synchronized (lock) {
            return statistic;
        }
    }

    /**
     * Entity to continuously putting an eye on the transactions and only keeping the latest transactions of 60 seconds.
     * 
     * @author jobanpreetsingh
     *
     */
    private class TransactionManager implements Runnable {

        public void run() {
            final Statistic newStats = new Statistic();
            synchronized (lock) {
                transactions = transactions.stream().filter(
                        input -> Instant.ofEpochMilli(input.getTimestamp()).isAfter(Instant.now().minusSeconds(60)))
                        .collect(Collectors.toList());
                transactions.forEach(input -> updateStatistics(input, newStats));
                statistic = newStats;
            }
        }

        /**
         * Method to compute the statistics of last 60 seconds transactions.
         * 
         * @param transaction
         */
        private void updateStatistics(final Transaction transaction, final Statistic newStats) {
            newStats.setCount(newStats.getCount() + 1);
            final double currentMax = newStats.getMax();
            final double currentMin = newStats.getMin();
            final double currentAmount = transaction.getAmount();
            if (currentAmount > currentMax) {
                newStats.setMax(currentAmount);
            }
            if (currentAmount < currentMin) {
                newStats.setMin(currentAmount);
            }
            newStats.setSum(newStats.getSum() + currentAmount);
        }
    }

}
