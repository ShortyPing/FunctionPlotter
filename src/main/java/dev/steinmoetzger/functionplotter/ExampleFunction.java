package dev.steinmoetzger.functionplotter;

import java.awt.*;

public class ExampleFunction extends Function {
    public ExampleFunction(Main main, Color color) {
        super(main, color);
    }

    @Override
    public double f(double x) {
        return x;
    }
}
