package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern POLYNOMIAL_PATTERN = Pattern.compile("([-+]?\\d+)(x\\^)(\\d+)\\s?|([-+]?\\d+)(x)|([-+]?\\d+)");
    public static void main(String[] args) {
        String polynomial = "23x^5+12x^4+72x^3-23x^2+45x^1+56";
        parsePolynomial(polynomial);
    }

    public static void parsePolynomial(String polynomial) {
        Matcher matcher = POLYNOMIAL_PATTERN.matcher(polynomial);
        while (matcher.find()) {
            String coefficient = matcher.group(1);
            String variable = matcher.group(2);
            String exponent = matcher.group(3);
            String firstPower = matcher.group(4);
            String xd=matcher.group(6);

            if (coefficient != null && !coefficient.isEmpty()) {
                System.out.println("Coefficient: " + coefficient);
            }
            if (variable != null && !variable.isEmpty()) {
                System.out.println("Variable: " + variable);
            }
            if (exponent != null && !exponent.isEmpty()) {
              System.out.println("Exponent: " + exponent);
           }
            if(xd != null)
                System.out.println("freeterm" + xd);
            System.out.println("\n");
            if(firstPower != null)
                System.out.println("firstpower: "+ firstPower);
        }
    }
}