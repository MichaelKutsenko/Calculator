package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lenovo on 05.03.2016.
 */
public class CJFrame extends JFrame {
    private Image icon = new ImageIcon(getClass().getResource("/Image/icon.png")).getImage();

    public CJFrame() throws HeadlessException {
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setIconImage(icon);
    }

    public CJFrame(String title) throws HeadlessException {
        super(title);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setIconImage(icon);
    }

    public CJFrame(String title, int width, int height)  throws HeadlessException {
        this(title);
        super.setSize(width, height);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setIconImage(icon);
    }

    public CJFrame(String title, int width, int height, LayoutManager layout)  throws HeadlessException {
        this(title, width, height);
        super.setLayout(layout);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setIconImage(icon);
    }
}
