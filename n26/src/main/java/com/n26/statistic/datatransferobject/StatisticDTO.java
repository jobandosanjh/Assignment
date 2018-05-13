package com.n26.statistic.datatransferobject;

/**
 * Data transfer object for handling data related to transactions statistics. This object is mainly used to transmit
 * data between client and server.
 * 
 * @author jobanpreetsingh
 *
 */
public class StatisticDTO {

    private Double sum;
    private Double avg;
    private Double max;
    private Double min;
    private Long count;

    public Double getSum() {
        return sum;
    }

    public void setSum(final Double sum) {
        this.sum = sum;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(final Double avg) {
        this.avg = avg;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(final Double max) {
        this.max = max;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(final Double min) {
        this.min = min;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(final Long count) {
        this.count = count;
    }

}
