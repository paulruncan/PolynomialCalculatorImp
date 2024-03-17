package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BussinesLogic.Operations;
import Model.Polynomial;
import Utils.PolynomialParser;
import View.InputStringValidator;

public class Controller implements ActionListener {
    private CalculatorView view;


    public Controller( CalculatorView view ) {
        this.view = view;
    }

    public void actionPerformed( ActionEvent e ) {
        String command = e.getActionCommand();
        if (command.equals("COMPUTE")) {
            String firstPolynomialAsString = view.getFirstNumberTextField().getText();
            //System.out.println(firstPolynomial);
            String secondPolynomialAsString = view.getSecondNumberTextField().getText();
            InputStringValidator validator = new InputStringValidator();
            try {
                validator.validate(firstPolynomialAsString);
                validator.validate(secondPolynomialAsString);
                Polynomial firstPolynomial = new Polynomial(PolynomialParser.parsePolynomial(firstPolynomialAsString));
                Polynomial secondPolynomial = new Polynomial(PolynomialParser.parsePolynomial(secondPolynomialAsString));
                Polynomial result = new Polynomial();
                Polynomial[] resultDivision = new Polynomial[2];
                String operation = String.valueOf(view.getOperationsComboBox().getSelectedItem());
                switch (operation) {
                    case "Add":
                        result = Operations.Add(firstPolynomial, secondPolynomial);
                        break;
                    case "Subtract":
                        result = Operations.Subtract(firstPolynomial, secondPolynomial);
                        break;
                    case "Multiply":
                        result = Operations.Multiply(firstPolynomial, secondPolynomial);
                        break;
                    case "Divide":
                        resultDivision = Operations.Divide(firstPolynomial, secondPolynomial);
                        break;
                    case "DeriveFirst":
                        result = Operations.Derive(firstPolynomial);
                        break;
                    case "IntegrateFirst":
                        result = Operations.Integrate(firstPolynomial);
                        break;
                }
                if (!operation.equals("Divide")) {
                    view.getResultValueLabel().setText(result.toString());
                    view.getRemainderLabel().setText("");
                    view.getRemainderResultLabel().setText("");
                } else {
                    view.getResultValueLabel().setText(resultDivision[0].toString());
                    view.getRemainderLabel().setText("Remainder");
                    view.getRemainderResultLabel().setText(resultDivision[1].toString());
                }
            } catch (Exception exception) {
                view.getRemainderResultLabel().setText("Wrong Polynomial Syntax");
                view.getRemainderLabel().setText("ERROR:");
                view.getResultValueLabel().setText("");

            }

        }
    }

}
