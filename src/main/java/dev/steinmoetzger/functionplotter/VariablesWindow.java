package dev.steinmoetzger.functionplotter;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class VariablesWindow extends JPanel implements ChangeListener {

    private final Main main;
    HashMap<String, JLabel> labelHashMap;

    public VariablesWindow(Main main) {
        this.main = main;
        this.labelHashMap = new HashMap<>();
        JFrame frame = new JFrame("Variables");
        frame.setVisible(true);
        frame.setSize(500, 500);

        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        main.getVariables().forEach((name, variable) -> {
            System.out.println((int) (variable.getMin() * 10));
            JSlider slider = new JSlider();
            slider.setMinimum((int) (variable.getMin() * 10));
            slider.setMaximum((int) (variable.getMax() * 10));
            slider.setValue((int) (variable.getValue() * 10));
            slider.setPaintLabels(true);
            slider.setVisible(true);
            slider.setName(name);
            slider.addChangeListener(this);
            JLabel label = new JLabel(name + " " + variable.getValue());
            labelHashMap.put(name, label);
            frame.add(label, gbc);
            frame.add(slider, gbc);
        });

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        this.main.getVariables().get(source.getName()).setValue((double) source.getValue() / 10);
        this.labelHashMap.get(source.getName()).setText(source.getName() + " " + ((double) source.getValue() / 10));
        this.main.repaint();

    }
}
