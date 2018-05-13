package com.n26.statistic.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.n26.statistic.datatransferobject.StatisticDTO;
import com.n26.statistic.model.Statistic;

/**
 * Test class for {@link StatisticMapper}.
 * 
 * @author jobanpreetsingh
 *
 */
public final class StatisticMapperTest {

    private Statistic statistic;
    private StatisticDTO statisticDTO;

    @Test
    public void testMapStatistic() {
        givenStatistic();
        whenMappingIsRequestedToStatisticDTO();
        thenStatisticIsMappedToStatisticDTO();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMapStatisticWithNullInput() {
        givenNullStatistic();
        whenMappingIsRequestedToStatisticDTO();
    }

    private void givenStatistic() {
        statistic = new Statistic();
        statistic.setCount(5);
        statistic.setMax(100);
        statistic.setMin(10);
        statistic.setSum(500);
    }

    private void givenNullStatistic() {
        statistic = null;
    }

    private void whenMappingIsRequestedToStatisticDTO() {
        statisticDTO = StatisticMapper.mapStatistic(statistic);
    }

    private void thenStatisticIsMappedToStatisticDTO() {
        assertNotNull(statisticDTO);
        assertEquals(Double.valueOf(statistic.getAvg()), statisticDTO.getAvg());
        assertEquals(Long.valueOf(statistic.getCount()), statisticDTO.getCount());
        assertEquals(Double.valueOf(statistic.getMax()), statisticDTO.getMax());
        assertEquals(Double.valueOf(statistic.getMin()), statisticDTO.getMin());
        assertEquals(Double.valueOf(statistic.getSum()), statisticDTO.getSum());
    }

}
