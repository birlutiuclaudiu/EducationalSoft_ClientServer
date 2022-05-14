package view;

import javax.swing.*;
import java.awt.*;


public class DrawingArea extends JPanel {

    public DrawingArea() {
        JLabel title = new JLabel("Drawing AREA");
        title.setAlignmentX(60);
        this.add(title);
        this.setPreferredSize(new Dimension(900, 600));
    }

}
