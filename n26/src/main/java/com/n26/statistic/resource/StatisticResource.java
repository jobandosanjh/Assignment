package com.n26.statistic.resource;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.n26.statistic.datatransferobject.StatisticDTO;

/**
 * Contract to declare CRUD operations related to statistic resource.
 * 
 * @author jobanpreetsingh
 *
 */
@RequestMapping("/statistics")
public interface StatisticResource {

    /**
     * Method to get the statistics.
     * 
     * @return {@link StatisticDTO}
     */
    @GetMapping(produces = "application/json")
    @ResponseStatus(OK)
    StatisticDTO getStatistics();

}
