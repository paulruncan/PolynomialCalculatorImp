package View;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputStringValidator implements Validator<String> {
    private static final Pattern POLYNOMIAL_PATTERN = Pattern.compile("(\\d+|[+-]\\d+|^x|[+-]x|\\d+x|[+-]\\d+x|x\\^\\d+|\\d+x\\^\\d+|[+-]\\d+x\\^\\d+|[+-]x\\^\\d+)+");

    @Override
    public void validate( String polynomial ) throws InputMismatchException {
        Matcher matcher = POLYNOMIAL_PATTERN.matcher(polynomial);
        if (!matcher.matches()) {
            throw new InputMismatchException("No Match!");
        }
    }
}
