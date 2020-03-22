import javax.swing.*;
import java.lang.reflect.Array;

public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JLabel label;
    JSpinner sidesField;
    JComboBox colorCombo;

    public ConfigPanel(MainFrame frame){
        this.frame = frame;
        init();
    }

    private void init(){
        label = new JLabel("Number of sides");
        sidesField = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        sidesField.setValue(6);
        colorCombo = new JComboBox(new String[]{"Random", "Black"});
        add(sidesField);
        add(sidesField);
        add(colorCombo);
    }
}
