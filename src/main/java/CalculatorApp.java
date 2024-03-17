import View.CalculatorView;

import javax.swing.*;

public class CalculatorApp {
    public static void main( String[] args ) {
        JFrame frame = new CalculatorView("Polynomial Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
