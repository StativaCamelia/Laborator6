package drawing;

import drawing.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ShapeSelect extends JPanel {
    final MainFrame frame;
    JComboBox shapeCombo;


    public ShapeSelect(MainFrame frame){
        this.frame = frame;
        init();
    }

    private void init(){
        shapeCombo = new JComboBox(new String[]{"Regular Polygon","Oval","Circle","Random"});
        add(shapeCombo);
        shapeCombo.addActionListener(this::changeConfigPanel);
    }

    private void changeConfigPanel(ActionEvent e){
        String selectedShape = (String)shapeCombo.getSelectedItem();
        if(selectedShape.equals("Regular Polygon"))
            this.frame.configPanel.initForRegularPolygon();
        else if(selectedShape.equals("Circle"))
            this.frame.configPanel.initForCircle();
        else if(selectedShape.equals("Oval"))
            this.frame.configPanel.initforOval();
    }

}


