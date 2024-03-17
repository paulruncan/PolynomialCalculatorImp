package Utils;

public class StringNumberParser {
    public static String ParseToInt( Number number ) {
        if (number.floatValue() == number.intValue())
            number = number.intValue();
        return number.toString();
    }
}
