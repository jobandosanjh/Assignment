package com.n26.statistic.model;

/**
 * Entity to hold data related to transaction statistics. This model is mainly used for the communication between
 * different layers of the application.
 * 
 * @author jobanpreetsingh
 *
 */
public class Statistic {

    private double sum;
    private double avg;
    private double max;
    private double min;
    private long count;

    public Statistic() {
        this.max = Double.MIN_VALUE;
        this.min = Double.MAX_VALUE;
    }

    public double getSum() {
        return this.sum;
    }

    public void setSum(final double sum) {
        this.sum = sum;
    }

    public double getAvg() {
        this.avg = this.count == 0 ? 0 : this.sum / this.count;
        return this.avg;
    }

    public double getMax() {
        return this.count == 0 ? 0 : this.max;
    }

    public void setMax(final double max) {
        this.max = max;
    }

    public double getMin() {
        return this.count == 0 ? 0 : this.min;
    }

    public void setMin(final double min) {
        this.min = min;
    }

    public long getCount() {
        return this.count;
    }

    public void setCount(final long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Statistic [sum=" + this.sum + ", avg=" + this.avg + ", max=" + this.max + ", min=" + this.min
                + ", count=" + this.count + "]";
    }

}
