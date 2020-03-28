import javax.swing.*;

import java.awt.*;

import static javax.swing.SpringLayout.NORTH;
import static javax.swing.SwingConstants.CENTER;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    ShapeSelect shapeSelect;

    public MainFrame(){
        super("My Drawing Application");
        init();
    }

    private void init(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        shapeSelect = new ShapeSelect(this);
        add(canvas, BorderLayout.CENTER);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        add(shapeSelect, BorderLayout.EAST);

        pack();
    }
}
