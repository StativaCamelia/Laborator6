import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W=800, H=600;

    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame){
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    /**
     * Se seteaza background-ul canvasului si este transformat intr-un drawing context
     * care ne permite sa desenam in cadrul acestuia.
     */
    public void createOffscreenImage(){
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,W,H);
    }

    @Override
    public void update(Graphics g) { }

    /**
     * am adaugat un listener pentru evenimentele de tipul mouseClick in interiorul acestuia. Actiunea realizata in urma evenimentului este data drept o lambda si 
     * invoca metodele drawShape (care primeste ca parametri coordonatele locului in care a avut loc evenimentul de tip mouseClick)si care apartine de clasa DrawingPanel 
     * si metoda repaint. Apelam metoda repaint pentru a semnaliza componentei ca isi modifice continutul, avand in vedere ca modificarile sunt de continut 
     * si nu de dimensiune, caz in care s-ar fi apelat metoda paint.
     */
    private void init(){
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    /**
     * Initial stabilim care vor fi parametrii(coloare, dmensiune, numar de laturi si figurii pe care o vom desena),
     * acest lucru se realizeaza fie random fie extrangand inputul din componentele care permit introducere de input din
     * MainFrame(ex sides =frame.configPanel.sidesField.getValue() ). Apoi sunt randate obiecte de tipul graphics care primesc drept parametrii, valorile obtinute anterior.
     * @param x
     * @param y
     */
    private void drawShape(int x, int y){
        double radius = Math.random()*100;
        int sides = (int)frame.configPanel.sidesField.getValue();
        Color color = new Color((int)Math.floor(Math.random()*255), (int)Math.floor(Math.random()*255), (int)Math.floor(Math.random()*255));

        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x,y,radius, sides));

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }




}
