package Model;

import java.util.TreeMap;

public class Polynomial {
    private TreeMap<Integer,Number> polynomial;

    Polynomial(TreeMap<Integer,Number> polynomial){
        this.polynomial=polynomial;
    }

    public TreeMap<Integer, Number> getPolynomial() {
        return polynomial;
    }

    public void setPolynomial( TreeMap<Integer, Number> polynomial ) {
        this.polynomial = polynomial;
    }
}
