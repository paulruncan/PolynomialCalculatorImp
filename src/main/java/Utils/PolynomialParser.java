package Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolynomialParser {
    private static final Pattern POLYNOMIAL_PATTERN = Pattern.compile("([-+]?\\d+)(x\\^)(\\d+)\\s?|([-+]?\\d+)(x)|([-+]?\\d+)");

    public static void parsePolynomial(String polynomial) {
        Matcher matcher = POLYNOMIAL_PATTERN.matcher(polynomial);
        while(matcher.find()) {
            String coefficient = matcher.group(1);
            String x = matcher.group(2);
            String exponent = matcher.group(3);
            String coeffFirstPower = matcher.group(4);
            String freeTerm = matcher.group(6);
        }
    }
}
