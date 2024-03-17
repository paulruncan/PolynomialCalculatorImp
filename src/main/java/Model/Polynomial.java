package Model;

import Utils.StringNumberParser;

import java.util.Map;
import java.util.TreeMap;

public class Polynomial {
    private TreeMap<Integer, Number> monomials;

    public Polynomial() {
        this.monomials = new TreeMap<>();
    }

    public Polynomial( Integer a, Number b ) {
        this.monomials = new TreeMap<>();
        this.monomials.put(a, b);
    }

    public Polynomial( TreeMap<Integer, Number> polynomial ) {
        this.monomials = polynomial;
    }

    public TreeMap<Integer, Number> getMonomials() {
        return monomials;
    }

    public void setMonomials( TreeMap<Integer, Number> monomials ) {
        this.monomials = monomials;
    }

    @Override
    public String toString() {
        StringBuilder buildString = new StringBuilder();
        for( Map.Entry<Integer, Number> entry : monomials.descendingMap().entrySet() ) {
            if (entry.getKey() == 0) {
                if (entry.getValue().floatValue() > 0)
                    buildString.append("+").append(StringNumberParser.ParseToInt(entry.getValue()));
                else if (entry.getValue().floatValue() < 0) {
                    buildString.append(StringNumberParser.ParseToInt(entry.getValue()));
                }
            } else if (entry.getKey().equals(monomials.lastKey())) {
                if (entry.getValue().floatValue() == -1)
                    buildString.append("-");
                else if (entry.getValue().floatValue() != 1)
                    buildString.append(StringNumberParser.ParseToInt(entry.getValue()));
                if (entry.getKey() == 1)
                    buildString.append("x");
                else buildString.append("x^").append(entry.getKey());
            } else {
                if (entry.getValue().floatValue() == -1)
                    buildString.append("-");
                else if (entry.getValue().floatValue() == 1)
                    buildString.append("+");
                else if (entry.getValue().floatValue() != 1 && entry.getValue().floatValue() > 0)
                    buildString.append("+").append(StringNumberParser.ParseToInt(entry.getValue()));
                else buildString.append(StringNumberParser.ParseToInt(entry.getValue()));

                if (entry.getKey() == 1)
                    buildString.append("x");
                else buildString.append("x^").append(entry.getKey());
            }
        }
        return buildString.toString();
    }

    public void addMonomial( Integer exponent, Number coefficient ) {
        this.monomials.put(exponent, coefficient);
    }
}
