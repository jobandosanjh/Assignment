package com.n26.statistic.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;

import com.n26.statistic.datatransferobject.StatisticDTO;
import com.n26.statistic.service.StatisticService;

/**
 * Entity to handle CRUD operations related to statistic resource.
 * 
 * @author jobanpreetsingh
 *
 */
@RestController
public class StatisticResourceImpl implements StatisticResource {

    private static final Logger LOG = LoggerFactory.getLogger(StatisticResourceImpl.class);

    private final StatisticService statisticService;

    @Autowired
    @Lazy
    public StatisticResourceImpl(final StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @Override
    public StatisticDTO getStatistics() {
        LOG.info("Entered getStatistics()");
        return StatisticMapper.mapStatistic(statisticService.getStatistics());
    }

}
