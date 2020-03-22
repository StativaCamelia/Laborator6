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
    private void save(ActionEvent e){
        try{
            ImageIO.write(frame.canvas.image, "PNG", new File("d:/text.png"));
        }
        catch (IOException ex){
            System.err.println(ex);
        }
    }

    private void load(ActionEvent e){
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("d:/text.png"));
            this.frame.canvas.image = img;
            frame.canvas.validate();
            frame.canvas.repaint();
        } catch (IOException ie) {
        ie.printStackTrace();
        }
    }

    private void reset(ActionEvent e){
        frame.canvas.createOffscreenImage();
        frame.canvas.validate();
        frame.canvas.repaint();
    }

    private void exit(ActionEvent e){
    frame.setVisible(false);
    frame.dispose();
    }


}
