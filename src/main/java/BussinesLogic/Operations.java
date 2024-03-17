package BussinesLogic;

import Model.Polynomial;

import java.util.Map;

public class Operations {
    public static Polynomial Add( Polynomial polynomialA, Polynomial polynomialB ) {
        Polynomial result = new Polynomial();
        for( Map.Entry<Integer, Number> entry : polynomialA.getMonomials().entrySet() ) {
            result.getMonomials().put(entry.getKey(), entry.getValue());
        }
        for( Map.Entry<Integer, Number> entry : polynomialB.getMonomials().entrySet() ) {
            if (result.getMonomials().containsKey(entry.getKey())) {
                result.getMonomials().put(entry.getKey(), result.getMonomials().get(entry.getKey()).intValue() + entry.getValue().intValue());
            } else result.getMonomials().put(entry.getKey(), entry.getValue());
            if (result.getMonomials().get(entry.getKey()).floatValue() == 0.0)
                result.getMonomials().remove(entry.getKey());
        }
        return result;
    }

    public static Polynomial Subtract( Polynomial polynomialA, Polynomial polynomialB ) {
        Polynomial result = new Polynomial();
        for( Map.Entry<Integer, Number> entry : polynomialA.getMonomials().entrySet() ) {
            result.getMonomials().put(entry.getKey(), entry.getValue());
        }
        for( Map.Entry<Integer, Number> entry : polynomialB.getMonomials().entrySet() ) {
            if (result.getMonomials().containsKey(entry.getKey())) {
                result.getMonomials().put(entry.getKey(), result.getMonomials().get(entry.getKey()).floatValue() - entry.getValue().floatValue());
            } else result.getMonomials().put(entry.getKey(), -entry.getValue().floatValue());
            if (result.getMonomials().get(entry.getKey()).floatValue() == 0.0)
                result.getMonomials().remove(entry.getKey());
        }
        return result;
    }

    public static Polynomial Multiply( Polynomial polynomialA, Polynomial polynomialB ) {
        Polynomial result = new Polynomial();
        for( Map.Entry<Integer, Number> entryA : polynomialA.getMonomials().descendingMap().entrySet() ) {
            for( Map.Entry<Integer, Number> entryB : polynomialB.getMonomials().descendingMap().entrySet() ) {
                if (!result.getMonomials().containsKey(entryA.getKey() + entryB.getKey())) {
                    result.getMonomials().put(entryA.getKey() + entryB.getKey(), entryA.getValue().floatValue() * entryB.getValue().floatValue());
                } else {
                    result.getMonomials().put(entryA.getKey() + entryB.getKey(), result.getMonomials().get(entryA.getKey() + entryB.getKey()).floatValue() + entryA.getValue().floatValue() * entryB.getValue().floatValue());
                }
            }
        }
        return result;
    }

    public static Polynomial Derive( Polynomial polynomial ) {
        Polynomial result = new Polynomial();
        for( Map.Entry<Integer, Number> entry : polynomial.getMonomials().entrySet() ) {
            if (entry.getKey() != 0) {
                result.getMonomials().put(entry.getKey() - 1, entry.getKey() * entry.getValue().intValue());
            }
        }
        return result;
    }

    public static Polynomial Integrate( Polynomial polynomial ) {
        Polynomial result = new Polynomial();
        for( Map.Entry<Integer, Number> entry : polynomial.getMonomials().descendingMap().entrySet() ) {
            result.getMonomials().put(entry.getKey() + 1, entry.getValue().floatValue() / (entry.getKey() + 1));
        }
        return result;
    }

    public static Polynomial[] Divide( Polynomial polynomialA, Polynomial polynomialB ) {
        Polynomial[] result = new Polynomial[2];
        result[0] = new Polynomial();
        result[1] = new Polynomial();
        while (polynomialA.getMonomials().lastKey() >= polynomialB.getMonomials().lastKey()) {
            result[0].getMonomials().put(polynomialA.getMonomials().lastKey() - polynomialB.getMonomials().lastKey(), polynomialA.getMonomials().get(polynomialA.getMonomials().lastKey()).floatValue() / polynomialB.getMonomials().get(polynomialB.getMonomials().lastKey()).floatValue());
            polynomialA = Operations.Subtract(polynomialA, Operations.Multiply(new Polynomial(polynomialA.getMonomials().lastKey() - polynomialB.getMonomials().lastKey(), polynomialA.getMonomials().get(polynomialA.getMonomials().lastKey()).floatValue() / polynomialB.getMonomials().get(polynomialB.getMonomials().lastKey()).floatValue()), polynomialB));
        }
        result[1] = polynomialA;
        return result;
    }
}
