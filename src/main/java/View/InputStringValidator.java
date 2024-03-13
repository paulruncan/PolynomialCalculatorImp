package View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputStringValidator implements Validator<String>{
    private static final Pattern POLYNOMIAL_PATTERN = Pattern.compile("(([-+]?\\d+|[-+]?)(x\\^)(\\d+)\\s?|([-+]?\\d+)(x|)()\\s?|([-+]?)(x)()\\s?)+");
    @Override
    public void validate( String polynomial ) throws Exception {
        Matcher matcher = POLYNOMIAL_PATTERN.matcher(polynomial);
        if(!matcher.matches())
        {
            throw new Exception("not good");
        }
    }
}
