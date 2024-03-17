package Utils;

import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialParser {
    private static final Pattern POLYNOMIAL_PATTERN = Pattern.compile("([-+]?\\d+|[-+]?)(x\\^?|)(\\d+|)\\s?");

    public static TreeMap<Integer, Number> parsePolynomial( String polynomial ) {
        Matcher matcher = POLYNOMIAL_PATTERN.matcher(polynomial);
        TreeMap<Integer, Number> polynom = new TreeMap<>();
        while (matcher.find()) {
            String coefficient = matcher.group(1);
            String var = matcher.group(2);
            String exponent = matcher.group(3);
            int coeffInt, expInt;
            if (coefficient.isEmpty() || coefficient.equals("+")) {
                coeffInt = 1;
            } else if (coefficient.equals("-")) {
                coeffInt = -1;
            } else coeffInt = Integer.parseInt(coefficient);
            if (var.isEmpty() && exponent.isEmpty()) {
                expInt = 0;
            } else if (exponent.isEmpty()) {
                expInt = 1;
            } else expInt = Integer.parseInt(exponent);
            if (coefficient.isEmpty() && var.isEmpty() && exponent.isEmpty()) {
                coeffInt = -1;
                expInt = -1;
            }
            if (polynom.containsKey(expInt)) {
                polynom.put(expInt, polynom.get(expInt).intValue() + coeffInt);
            } else polynom.put(expInt, coeffInt);
        }
        if (polynom.containsKey(-1))
            polynom.remove(-1);
        return polynom;
    }
}
