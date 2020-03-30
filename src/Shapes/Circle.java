package Shapes;
import javax.swing.*;
import java.awt.geom.Ellipse2D;

public class Circle extends JComponent {
        Ellipse2D.Double ellipse;


        public Ellipse2D createComponent(int x, int y, int radius)
        {
            ellipse = new Ellipse2D.Double(x, y, radius, radius);
            return ellipse;
        }
}
