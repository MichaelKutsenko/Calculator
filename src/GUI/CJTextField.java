package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lenovo on 06.03.2016.
 */
public class CJTextField extends JTextField {
    public CJTextField() {
    }

    public CJTextField(int width, int height) {
        super.setPreferredSize(new Dimension(width, height));
        this.setFont(new Font(this.getName(), Font.PLAIN, 15));
        this.setHorizontalAlignment(SwingConstants.RIGHT);
        this.setFocusable(false);
    }

    public CJTextField(int width, int height, JPanel panel) {
        this(width, height);
        panel.add(this);
    }
}

