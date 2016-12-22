package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lenovo on 04.03.2016.
 */
public class CJButton extends JButton{
    public CJButton() {
    }

    public CJButton(String title) {
        super(title);
    }

    public CJButton(String title, JPanel panel){
        this(title);
        panel.add(this);
    }

    public CJButton(String title, int width, int height) {
        this(title);
        super.setPreferredSize(new Dimension(width, height));
    }

    public CJButton(String title, int width, int height, JPanel panel) {
        this(title, width, height);
        panel.add(this);
    }

    public CJButton(String title, int width, int height, Color color) {
        this(title, width, height);
        super.setForeground(color);
    }

    public CJButton(String title, int width, int height, JPanel panel, Color color) {
        this(title, width, height, panel);
        super.setForeground(color);
    }

}
