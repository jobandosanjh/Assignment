package com.n26.statistic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.n26.backend.N26Backend;
import com.n26.statistic.model.Statistic;

/**
 * Entity to handle the business operations related to statistics.
 * 
 * @author jobanpreetsingh
 *
 */
@Service
@Lazy
public class StatisticServiceImpl implements StatisticService {

    private static final Logger LOG = LoggerFactory.getLogger(StatisticServiceImpl.class);

    private final N26Backend backend;

    @Autowired
    @Lazy
    public StatisticServiceImpl(final N26Backend backend) {
        this.backend = backend;
    }

    @Override
    public Statistic getStatistics() {
        LOG.info("Entered getStatistics()");
        return backend.getStatistics();
    }

}
