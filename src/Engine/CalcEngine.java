package Engine;

import GUI.CJFrame;
import GUI.CJTextField;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lenovo on 06.03.2016.
 */
public class CalcEngine implements ActionListener {
    private CJTextField textField;
    private CJFrame frame;

    ScriptEngineManager engineManager = new ScriptEngineManager();
    ScriptEngine engine = engineManager.getEngineByName("js");

    public CalcEngine(CJTextField textField, CJFrame frame) {
        this.textField = textField;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(e.getSource() instanceof JButton)){
            return;
        }

        JButton button = (JButton) e.getSource();

        String text;

        if (textField.getText().equals("Infinity") || (textField.getText().equals("0"))){
            text = "";
        } else {
            text = textField.getText();
        }

        if (button.getActionCommand().equals("=")){
            if (text.equals("")){
                return;
            }

            if (text.charAt(text.length() - 1) == '('){
                text = text.substring(0, text.length() - 4);
            } else text = delSignBefore(text);

            int missBrackets = doCheckBrackets(text);

            if (missBrackets > 0){
                for (int i = 0; i < missBrackets; i++){
                    text = text + ")";
                }

                JOptionPane.showMessageDialog(frame, "You haven't closed brackets. Program will do it automatically: " +
                        '\n'+ '\n'+ text, "Wrong input", 2);
            }

            text = text.replace('x', '*');

            try {
                Object result = engine.eval(text);

                text = result.toString();

                textField.setText(text);
            } catch (ScriptException sExc) {
                sExc.printStackTrace();
            }

            return;
        }


        String textPressed = "";

        if (button.getActionCommand().equals("0")){
            textPressed = "0";
        } else if (button.getActionCommand().equals("1")){
            textPressed = "1";
        }else if (button.getActionCommand().equals("2")){
            textPressed = "2";
        }else if (button.getActionCommand().equals("3")){
            textPressed = "3";
        }else if (button.getActionCommand().equals("4")){
            textPressed = "4";
        }else if (button.getActionCommand().equals("5")){
            textPressed = "5";
        }else if (button.getActionCommand().equals("6")){
            textPressed = "6";
        }else if (button.getActionCommand().equals("7")){
            textPressed = "7";
        }else if (button.getActionCommand().equals("8")){
            textPressed = "8";
        }else if (button.getActionCommand().equals("9")){
            textPressed = "9";
        }else if (button.getActionCommand().equals("/")){
            if (checkPreviousSign(text)) return;

            text = delSignBefore(text);
            textPressed = " / ";

        }else if (button.getActionCommand().equals("x")){
            if (checkPreviousSign(text)) return;

            text = delSignBefore(text);
            textPressed = " x ";

        }else if (button.getActionCommand().equals("-")){
            if (checkPreviousSign(text)) return;

            text = delSignBefore(text);
            textPressed = " - ";

        }else if (button.getActionCommand().equals("+")){
            if (checkPreviousSign(text)) return;

            text = delSignBefore(text);
            textPressed = " + ";

        }else if (button.getActionCommand().equals("(")){
            if (text.equals("") || text.charAt(text.length() - 1) == ' '){
                textPressed = "(";
            }else return;

        }else if (button.getActionCommand().equals(")")){
            if (doCheckBrackets(text) == 0 || text.charAt(text.length() - 1) == ' ' ||
                    text.charAt(text.length() - 1) == '(' ){
                return;
            }else textPressed = ")";

        }else if (button.getActionCommand().equals(".")){
            String[] parts = text.split(" ");
            if (parts[parts.length - 1].contains(".")) {
                return;
            }
            textPressed = ".";

        }else if (button.getActionCommand().equals("<")) {
            if (text.equals("") || text.length() == 1){
                text = "0";
            }else if (text.charAt(text.length() - 1) == ' '){
                text = text.substring(0, text.length() - 3);
            } else {
                text = text.substring(0, text.length() - 1);
            }

        }else if (button.getActionCommand().equals("C")) {
            text = "0";
        }

        textField.setText(text + textPressed);
    }

    private boolean checkPreviousSign(String text) {
        if (text.equals("") || text.charAt(text.length() - 1) == '('){
            return true;
        }
        return false;
    }

    private String delSignBefore(String text) {
        if (text.charAt(text.length() - 1) == ' '){
            text = text.substring(0, text.length() - 3);
        }
        return text;
    }

    // check whether the count of RightBrackets bigger then the count of LeftBrackets
    private int doCheckBrackets(String text) {
        int countLeftBracket = 0;
        int countRightBracket = 0;

        String[] members = text.split("");
        for (int i = 0; i < members.length; i++){
            if (members[i].equals("(")){
                countLeftBracket++;
            }else if (members[i].equals(")")){
                countRightBracket++;
            }
        }

        return countLeftBracket - countRightBracket;
    }
}
