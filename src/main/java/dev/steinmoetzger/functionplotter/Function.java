package dev.steinmoetzger.functionplotter;

import java.awt.*;

public abstract class Function {

    protected final Main main;
    public Function(Main main, Color color) {
        this.color = color;
        this.main = main;
    }

    private Color color;


    public abstract double f(double x);

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
