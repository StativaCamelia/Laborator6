import javafx.scene.shape.Shape3D;

import java.awt.*;

public class Random extends Polygon{
     int x;
     int y;
     int side;

     Random(int x, int y, int side){
     this.x = x;
     this.y = y;
     this.side = side;

    this.addPoint(x, y);
    this.addPoint(x+20, y);
    this.addPoint(x, y+20);
    this.addPoint(x+20, y);
    }
}
