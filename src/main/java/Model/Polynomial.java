package Model;

import java.util.Map;
import java.util.TreeMap;

public class Polynomial {
    private TreeMap<Integer, Number> monomials;

    public Polynomial(){
        this.monomials=new TreeMap<>();
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
            if (entry.getKey() != -1) {
                if(entry.getValue().floatValue()>0)
                    buildString.append("+");
                buildString.append(entry.getValue().toString());
                if(entry.getKey()==1)
                    buildString.append("x");
                else if(entry.getKey()>1)
                    buildString.append("x^"+entry.getKey().toString());
            }
        }
        return buildString.toString();
    }
    public void addMonomial(Integer exponent, Number coefficient)
    {
        this.monomials.put(exponent,coefficient);
    }
}
