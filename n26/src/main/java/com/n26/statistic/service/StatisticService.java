package com.n26.statistic.service;

import com.n26.statistic.model.Statistic;

/**
 * Contract to declare the business operations related to statistics.
 * 
 * @author jobanpreetsingh
 *
 */
public interface StatisticService {

    /**
     * Method to get the statistics.
     * 
     * @return {@link Statistic}
     */
    Statistic getStatistics();
}
