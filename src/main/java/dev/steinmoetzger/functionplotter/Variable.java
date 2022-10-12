package dev.steinmoetzger.functionplotter;

public class Variable {

    private double value;
    private double max;
    private double min;

    public Variable(double value, double min, double max) {
        this.value = value;
        this.max = max;
        this.min = min;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }
}
