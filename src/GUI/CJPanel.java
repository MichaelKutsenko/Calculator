package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lenovo on 05.03.2016.
 */
public class CJPanel extends JPanel {
    public CJPanel() {
    }

    public CJPanel(LayoutManager layout) {
        super.setLayout(layout);
    }

    public CJPanel(LayoutManager layout, boolean border) {
        super.setLayout(layout);
        if (border == true){
            super.setBorder(BorderFactory.createEtchedBorder());
        }
    }

    public CJPanel(int width, int height) {
        Dimension dimension = new Dimension(width, height);
        super.setPreferredSize(dimension);
        super.setMinimumSize(dimension);
        super.setMaximumSize(dimension);
    }

    public CJPanel(int width, int height, boolean border) {
        Dimension dimension = new Dimension(width, height);
        super.setPreferredSize(dimension);
        super.setMinimumSize(dimension);
        super.setMaximumSize(dimension);
        if (border == true){
            super.setBorder(BorderFactory.createEtchedBorder());
        }
    }

    public CJPanel(int width, int height, LayoutManager layout) {
        this(width, height);
        super.setLayout(layout);
    }

    public CJPanel(int width, int height, LayoutManager layout, boolean border) {
        this(width, height);
        super.setLayout(layout);
        if (border == true){
            super.setBorder(BorderFactory.createEtchedBorder());
        }
    }
}
