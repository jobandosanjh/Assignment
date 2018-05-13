package com.n26.statistic.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import com.n26.backend.N26Backend;
import com.n26.statistic.model.Statistic;

/**
 * Test class for {@link StatisticServiceImpl}.
 * 
 * @author jobanpreetsingh
 *
 */
public final class StatisticServiceImplTest {

    private Statistic expected;
    private Statistic actual;
    private StatisticService statisticService;

    @Test
    public void testGetStatistics() {
        givenExpectedStatistics();
        givenMocks();
        whenStatisticsAreRequested();
        thenStatisticsAreRetrieved();
    }

    private void givenExpectedStatistics() {
        expected = new Statistic();
        expected.setCount(5);
        expected.setMax(100);
        expected.setMin(10);
        expected.setSum(500);
    }

    private void givenMocks() {
        final N26Backend n26Backend = mock(N26Backend.class);
        when(n26Backend.getStatistics()).thenReturn(expected);
        statisticService = new StatisticServiceImpl(n26Backend);
    }

    private void whenStatisticsAreRequested() {
        actual = statisticService.getStatistics();
    }

    private void thenStatisticsAreRetrieved() {
        assertNotNull(actual);
        assertEquals(expected.getAvg(), actual.getAvg(), 0);
        assertEquals(expected.getCount(), actual.getCount(), 0);
        assertEquals(expected.getMax(), actual.getMax(), 0);
        assertEquals(expected.getMin(), actual.getMin(), 0);
        assertEquals(expected.getSum(), actual.getSum(), 0);

    }

}
