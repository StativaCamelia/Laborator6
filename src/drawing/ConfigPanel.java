package drawing;

import javax.swing.*;
import java.lang.reflect.Array;

public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JLabel label;
    JLabel labelDim;
    JSpinner radiusField;
    JSpinner sidesField;
    JComboBox colorCombo;

    public ConfigPanel(MainFrame frame){
        this.frame = frame;
        init();
    }

    /**
     * Zona de configurari va contine doua forme de introducere al input-ului de catre utilizator.
     * Un JSpinner - pentru selectarea numarului de laturi.
     * Un ComboBox(dropdown) - pentru selectarea culorii
     * Exista si un label pentru identificarea continutului JSpinner-ului
     */
    public void initForRegularPolygon(){
        this.removeAll();
        label = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(3,3,100,1));
        sidesField.setValue(6);
        labelDim = new JLabel("Side Lenght");
        radiusField = new JSpinner(new SpinnerNumberModel(10,1,100,1));
        sidesField.setValue(10);
        colorCombo = new JComboBox(new String[]{"Random", "Black"});
        add(label);
        add(sidesField);
        add(labelDim);
        add(radiusField);
        add(colorCombo);
        this.validate();
        this.repaint();
    }

    public void initForCircle(){
        this.removeAll();
        label = new JLabel("Radius:");
        radiusField = new JSpinner(new SpinnerNumberModel(10,1,100,1));
        colorCombo = new JComboBox(new String[]{"Random", "Black"});
        add(label);
        add(radiusField);
        add(colorCombo);
        this.validate();
        this.repaint();
    }

    public void initforOval(){
        this.removeAll();
        label = new JLabel("Width:");
        sidesField = new JSpinner(new SpinnerNumberModel(3,3,100,1));
        sidesField.setValue(6);
        labelDim = new JLabel("Height");
        radiusField = new JSpinner(new SpinnerNumberModel(10,1,100,1));
        sidesField.setValue(10);
        colorCombo = new JComboBox(new String[]{"Random", "Black"});
        add(label);
        add(sidesField);
        add(labelDim);
        add(radiusField);
        add(colorCombo);
        this.validate();
        this.repaint();
    }

    private void init(){
        label = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(3,3,100,1));
        sidesField.setValue(6);
        labelDim = new JLabel("Side Lenght");
        radiusField = new JSpinner(new SpinnerNumberModel(10,1,100,1));
        radiusField.setValue(10);
        colorCombo = new JComboBox(new String[]{"Random", "Black"});
        add(label);
        add(sidesField);
        add(labelDim);
        add(radiusField);
        add(colorCombo);

    }
}
