package dev.steinmoetzger.functionplotter;

import org.apache.commons.math3.util.Precision;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Main extends JPanel {
    private final int minX;
    private final int maxX;
    private final int minY;
    private final int maxY;

    private final HashMap<String, Variable> variables;

    JFrame frame;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        this.variables = new HashMap<>();
        this.registerVariables();
        if(!this.variables.isEmpty())
            new VariablesWindow(this);
        this.minX = -100;
        this.maxX = 100;
        this.minY = -100;
        this.maxY = 100;
        this.frame = new JFrame("FunctionPlotter");

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(1000, 1000);
        this.frame.setVisible(true);
        this.frame.add(this);


    }

    public HashMap<String, Variable> getVariables() {
        return variables;
    }

    public int calculateCoordinate(double number, boolean y) {
        if(y)
            number *= (-1);
        int i = (int) (Precision.round(number, 1) * 10);
        i += 500;
        return i;
    }


    public void registerVariables() {
    }

    public void registerVariable(String name, double defaultValue, double max, double min) {
        this.variables.put(name, new Variable(defaultValue, max, min));
    }

    public double getVariable(String name) {
        if(!this.variables.containsKey(name))
            return 0;
        return this.variables.get(name).getValue();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillRect(500, 500, 1, 1);
        g.drawLine(0, 500, 1000, 500);
        g.drawLine(500, 0, 500, 1000);

        g.setColor(Color.BLACK);

        int lastX = -1;
        int lastY = -1;

        for(double i = -100; i < 50d; i+=0.1) {
            double x = f(i);
            if(lastX != -1) {
                g.drawLine(lastX, lastY, calculateCoordinate(i, false), calculateCoordinate(x, true));
            }

            lastX = calculateCoordinate(i, false);
            lastY = calculateCoordinate(x, true);
            g.fillRect(lastX, lastY, 1, 1);
        }

    }

    public double f(double x) {
        return x;
    }


}
