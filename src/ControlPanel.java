import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame){
        this.frame = frame;
        init();
    }

    private void init(){
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);

    }

    /**
     * Extrage din MainFrame-ul din care face parte(care este de altfel unul din atributele clasei), canvasul curent(reprezentat de un obiect de tip BufferedImage)
     * si il scrie intr-un file cu extensia .png.
     * @param e
     */
    private void save(ActionEvent e){
        try{
            ImageIO.write(frame.canvas.image, "PNG", new File("d:/text.png"));
        }
        catch (IOException ex){
            System.err.println(ex);
        }
    }

    /**
     * Citeste o imagine din FIle System si inlocuieste imaginea care reprezinta canvas-ul actula cu acesta. Apoi pentru a putea adauga in continuare elemente,
     * transforma si aceasta imagine intr-un "drawing context". Apelam repain pentru a propaga modificarile facute.
     * @param e
     */
    private void load(ActionEvent e){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("d:/text.png"));
            this.frame.canvas.image = img;
            this.frame.canvas.graphics = this.frame.canvas.image.createGraphics();
            frame.canvas.validate();
            frame.canvas.repaint();
        } catch (IOException ie) {
        ie.printStackTrace();
        }
    }

    /**
     * Apeleaza functia createOffscreenImage, care readuce canvas-ul in stadiul in care era la deschiderea aplicatie.
     * @param e
     */
    private void reset(ActionEvent e){
        frame.canvas.createOffscreenImage();
        frame.canvas.validate();
        frame.canvas.repaint();
    }

    /**
     * Ascunde vizibilitatea MainFrame-ului si apoi distruge acest obiect.
     * @param e
     */
    private void exit(ActionEvent e){
    frame.setVisible(false);
    frame.dispose();
    }


}
