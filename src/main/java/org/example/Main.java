package org.example;

import Model.Polynomial;
import Utils.PolynomialParser;
import View.InputStringValidator;

import java.util.regex.Pattern;

public class Main {
    private static final Pattern POLYNOMIAL_PATTERN = Pattern.compile("([-+]?\\d+|[-+]?)(x\\^?|)(\\d+|)");
    public static void main(String[] args) throws Exception {
        String polynomial = "7x^4+5x^3-12x^2+15x+7";
        int a=2;
        double b=2.0;
        Polynomial exemplu = new Polynomial();
        exemplu.addMonomial(1,22.3);
        exemplu.addMonomial(0,22.5);
        exemplu.addMonomial(2,28.3);
        System.out.println(exemplu.toString());
        if(a==b)
            System.out.println("da");
        InputStringValidator validator = new InputStringValidator();
        validator.validate(polynomial);
        Polynomial Polynom = new Polynomial(PolynomialParser.parsePolynomial(polynomial));
        System.out.println(Polynom.toString());
        for(Integer keye: Polynom.getMonomials().keySet()){
            System.out.println("coeff: " + Polynom.getMonomials().get(keye) + " key: " + keye);
        }

    }

}