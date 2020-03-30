package Shapes;

import javax.swing.*;
import java.awt.geom.Ellipse2D;

public class Oval extends JComponent {
    Ellipse2D.Double ellipse;


    public Ellipse2D createComponent(int x, int y, int radiusX, int radiusY)
    {
        ellipse = new Ellipse2D.Double(x, y, radiusX, radiusY);
        return ellipse;
    }
}
