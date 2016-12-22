package Start;

import GUI.CJButton;
import GUI.CJFrame;
import GUI.CJPanel;
import GUI.CJTextField;
import Engine.CalcEngine;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Lenovo on 01.03.2016.
 */
public class StartCalc {
    private CJTextField textField;

    private CJButton btnZero;
    private CJButton btnOne;
    private CJButton btnTwo;
    private CJButton btnThree;
    private CJButton btnFour;
    private CJButton btnFive;
    private CJButton btnSix;
    private CJButton btnSeven;
    private CJButton btnEight;
    private CJButton btnNine;

    private CJButton btnPoint;
    private CJButton btnEqually;

    private CJButton btnLeftBracket;
    private CJButton btnRightBracket;
    private CJButton btnC;
    private CJButton btnBackSpace;

    private CJButton btnDivide;
    private CJButton btnMultiply;
    private CJButton btnMinus;
    private CJButton btnPlus;

    private CJPanel topPanel;
    private CJPanel middlePanel;
    private CJPanel mainPanel;

    private CJPanel middleRightPanel;
    private CJPanel middleLeftPanel;
    private CJPanel centerPanel;
    private CJPanel rightPanel;

    private CJFrame frame;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new AcrylLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame.setDefaultLookAndFeelDecorated(true);

        StartCalc calculator = new StartCalc();

        calculator.createPanel();
        calculator.createTextField();
        calculator.createButtons();
        calculator.createFrame();

    }

    private void createPanel(){
        topPanel = new CJPanel(240, 45, new FlowLayout(2, 5, 5), false);

        middlePanel = new CJPanel(244, 50, new FlowLayout(1, 0, 0));
        middleLeftPanel = new CJPanel(180, 50, new FlowLayout());
        middleRightPanel = new CJPanel(60, 50, new FlowLayout());
        middlePanel.add(middleLeftPanel);
        middlePanel.add(middleRightPanel);

        mainPanel = new CJPanel(new FlowLayout(1, 0, 0), false);
        centerPanel = new CJPanel(180, 170, new FlowLayout(), false);
        rightPanel = new CJPanel(60, 170, new FlowLayout(), false);
        mainPanel.add(centerPanel);
        mainPanel.add(rightPanel);
    }

    private void createTextField() {
        textField = new CJTextField(225, 40, topPanel);
        textField.setText("0");
    }

    private void createButtons(){
        btnLeftBracket = new CJButton("(", 50, 35, middleLeftPanel);
        btnRightBracket = new CJButton(")", 50, 35, middleLeftPanel);
        btnC = new CJButton("C", 50, 35, middleLeftPanel);

        btnBackSpace = new CJButton("<", 50, 35, middleRightPanel);

        btnNine = new CJButton("9", 50, 35, centerPanel);
        btnEight = new CJButton("8", 50, 35, centerPanel);
        btnSeven = new CJButton("7", 50, 35, centerPanel);
        btnSix = new CJButton("6", 50, 35, centerPanel);
        btnFive = new CJButton("5", 50, 35, centerPanel);
        btnFour = new CJButton("4", 50, 35, centerPanel);
        btnThree = new CJButton("3", 50, 35, centerPanel);
        btnTwo = new CJButton("2", 50, 35, centerPanel);
        btnOne = new CJButton("1", 50, 35, centerPanel);
        btnZero = new CJButton("0", 50, 35, centerPanel);
        btnPoint = new CJButton(".", 50, 35, centerPanel);
        btnEqually = new CJButton("=", 50, 35, centerPanel);

        btnDivide = new CJButton("/", 50, 35, rightPanel);
        btnMultiply = new CJButton("x", 50, 35, rightPanel);
        btnMinus = new CJButton("-", 50, 35, rightPanel);
        btnPlus = new CJButton("+", 50, 35, rightPanel);

        // Change font of buttons ".", "=", "-" in two times
        changeFontSize(btnPoint, 2);
        changeFontSize(btnEqually, 2);
        changeFontSize(btnMinus, 2);
        changeFontSize(btnBackSpace, 2);

        addButtonListeners();
    }

    private void addButtonListeners() {
        CalcEngine engine = new CalcEngine(textField, frame);

        btnEqually.addActionListener(engine);

        btnLeftBracket.addActionListener(engine);
        btnRightBracket.addActionListener(engine);

        btnNine.addActionListener(engine);
        btnEight.addActionListener(engine);
        btnSeven.addActionListener(engine);
        btnSix.addActionListener(engine);
        btnFive.addActionListener(engine);
        btnFour.addActionListener(engine);
        btnThree.addActionListener(engine);
        btnTwo.addActionListener(engine);
        btnOne.addActionListener(engine);
        btnZero.addActionListener(engine);
        btnPoint.addActionListener(engine);

        btnDivide.addActionListener(engine);
        btnMultiply.addActionListener(engine);
        btnMinus.addActionListener(engine);
        btnPlus.addActionListener(engine);

        btnC.addActionListener(engine);
        btnBackSpace.addActionListener(engine);
    }

    private void createFrame(){

        frame = new CJFrame("Calculator", 260, 300);

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));

        frame.getContentPane().add(topPanel);
        frame.getContentPane().add(middlePanel);
        frame.getContentPane().add(mainPanel);

        frame.setResizable(false);

        frame.setVisible(true);
    }

    private void changeFontSize(JButton button, int times) {
        button.setFont(new Font(button.getName(), Font.PLAIN, button.getFont().getSize()*times));
    }
}
