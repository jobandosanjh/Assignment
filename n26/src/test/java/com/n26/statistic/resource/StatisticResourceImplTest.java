package com.n26.statistic.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.n26.statistic.datatransferobject.StatisticDTO;
import com.n26.statistic.model.Statistic;
import com.n26.statistic.service.StatisticService;

/**
 * Test class for {@link StatisticResourceImpl}.
 * 
 * @author jobanpreetsingh
 *
 */
public final class StatisticResourceImplTest {

    private Statistic statistic;
    private StatisticDTO statisticDTO;
    private StatisticResource statisticResource;

    @Test
    public void testGetStatistics() {
        givenStatistic();
        givenMocks();
        whenStatisticsAreRequested();
        thenStatisticsAreRetrieved();
    }

    private void givenStatistic() {
        statistic = new Statistic();
        statistic.setCount(5);
        statistic.setMax(100);
        statistic.setMin(10);
        statistic.setSum(500);
    }

    private void givenMocks() {
        final StatisticService statisticService = mock(StatisticService.class);
        when(statisticService.getStatistics()).thenReturn(statistic);
        statisticResource = new StatisticResourceImpl(statisticService);
    }

    private void whenStatisticsAreRequested() {
        statisticDTO = statisticResource.getStatistics();
    }

    private void thenStatisticsAreRetrieved() {
        assertNotNull(statisticDTO);
        assertEquals(Double.valueOf(statistic.getAvg()), statisticDTO.getAvg());
        assertEquals(Long.valueOf(statistic.getCount()), statisticDTO.getCount());
        assertEquals(Double.valueOf(statistic.getMax()), statisticDTO.getMax());
        assertEquals(Double.valueOf(statistic.getMin()), statisticDTO.getMin());
        assertEquals(Double.valueOf(statistic.getSum()), statisticDTO.getSum());

    }

}
