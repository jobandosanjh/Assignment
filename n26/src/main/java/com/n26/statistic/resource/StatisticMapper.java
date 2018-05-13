package com.n26.statistic.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.n26.statistic.datatransferobject.StatisticDTO;
import com.n26.statistic.model.Statistic;

/**
 * Utility to map the data from {@link StatisticDTO} into {@link Statistic} or vice-versa.
 * 
 * @author jobanpreetsingh
 *
 */
final class StatisticMapper {

    private static final Logger LOG = LoggerFactory.getLogger(StatisticMapper.class);

    private StatisticMapper() {
    }

    /**
     * Method to map the data of {@link Statistic} into {@link StatisticDTO}.
     * 
     * @param statistic
     * @return {@link StatisticDTO}
     */
    static StatisticDTO mapStatistic(final Statistic statistic) {
        LOG.info("Entered mapStatistic(statistic = {})", statistic);
        Assert.notNull(statistic, "Statistic can not be null!");
        final StatisticDTO statisticDTO = new StatisticDTO();
        statisticDTO.setAvg(statistic.getAvg());
        statisticDTO.setCount(statistic.getCount());
        statisticDTO.setMax(statistic.getMax());
        statisticDTO.setMin(statistic.getMin());
        statisticDTO.setSum(statistic.getSum());
        return statisticDTO;
    }

}
