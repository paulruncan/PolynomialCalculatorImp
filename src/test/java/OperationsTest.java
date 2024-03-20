import BussinesLogic.Operations;
import Model.Polynomial;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {
    @Test
    public void testAdd(){
        Polynomial polynomialA,polynomialB,result;
        polynomialA=new Polynomial();
        polynomialA.getMonomials().put(5,4);
        polynomialA.getMonomials().put(4,-3);
        polynomialA.getMonomials().put(2,1);
        polynomialA.getMonomials().put(1,-8);
        polynomialA.getMonomials().put(0,1);
        polynomialB=new Polynomial();
        polynomialB.getMonomials().put(4,3);
        polynomialB.getMonomials().put(3,-1);
        polynomialB.getMonomials().put(2,1);
        polynomialB.getMonomials().put(1,2);
        polynomialB.getMonomials().put(0,-1);
        result = new Polynomial();
        result.getMonomials().put(5,4);
        result.getMonomials().put(3,-1);
        result.getMonomials().put(2,2);
        result.getMonomials().put(1,-6);
        assertEquals(Operations.Add(polynomialA,polynomialB).toString(),result.toString());
    }
    @Test
    public void testSubtract(){
        Polynomial polynomialA,polynomialB,result;
        polynomialA=new Polynomial();
        polynomialA.getMonomials().put(5,4);
        polynomialA.getMonomials().put(4,-3);
        polynomialA.getMonomials().put(2,1);
        polynomialA.getMonomials().put(1,-8);
        polynomialA.getMonomials().put(0,1);
        polynomialB=new Polynomial();
        polynomialB.getMonomials().put(4,3);
        polynomialB.getMonomials().put(3,-1);
        polynomialB.getMonomials().put(2,1);
        polynomialB.getMonomials().put(1,2);
        polynomialB.getMonomials().put(0,-1);
        result = new Polynomial();
        result.getMonomials().put(5,4);
        result.getMonomials().put(4,-6);
        result.getMonomials().put(3,1);
        result.getMonomials().put(1,-10);
        result.getMonomials().put(0,2);
        assertEquals(Operations.Subtract(polynomialA,polynomialB).toString(),result.toString());
    }

    @Test
    public void testMultiply(){
        Polynomial polynomialA,polynomialB,result;
        polynomialA=new Polynomial();
        polynomialA.getMonomials().put(2,3);
        polynomialA.getMonomials().put(1,-1);
        polynomialA.getMonomials().put(0,1);
        polynomialB=new Polynomial();
        polynomialB.getMonomials().put(1,1);
        polynomialB.getMonomials().put(0,-2);
        result = new Polynomial();
        result.getMonomials().put(3,3);
        result.getMonomials().put(2,-7);
        result.getMonomials().put(1,3);
        result.getMonomials().put(0,-2);
        assertEquals(Operations.Multiply(polynomialA,polynomialB).toString(),result.toString());
    }

    @Test
    public void testDivision(){
        Polynomial polynomialA,polynomialB;
        Polynomial[] result = new Polynomial[2];
        polynomialA=new Polynomial();
        polynomialA.getMonomials().put(3,1);
        polynomialA.getMonomials().put(2,-2);
        polynomialA.getMonomials().put(1,6);
        polynomialA.getMonomials().put(0,-5);
        polynomialB=new Polynomial();
        polynomialB.getMonomials().put(2,1);
        polynomialB.getMonomials().put(0,-1);
        result[0] = new Polynomial();
        result[0].getMonomials().put(1,1);
        result[0].getMonomials().put(0,-2);
        result[1] =new Polynomial();
        result[1].getMonomials().put(1,7);
        result[1].getMonomials().put(0,-7);
        Polynomial[] forCheck;
        forCheck=Operations.Divide(polynomialA,polynomialB);
        assertEquals(forCheck[0].toString(),result[0].toString());
        assertEquals(forCheck[1].toString(),result[1].toString());
    }

    @Test
    public void testDerive(){
        Polynomial polynomial,result;
        polynomial=new Polynomial();
        polynomial.getMonomials().put(3,1);
        polynomial.getMonomials().put(2,-2);
        polynomial.getMonomials().put(1,6);
        polynomial.getMonomials().put(0,-5);
        result = new Polynomial();
        result.getMonomials().put(2,3);
        result.getMonomials().put(1,-4);
        result.getMonomials().put(0,6);
        assertEquals(Operations.Derive(polynomial).toString(),result.toString());
    }

    @Test
    public void testIntegrate(){
        Polynomial polynomial,result;
        polynomial=new Polynomial();
        polynomial.getMonomials().put(3,1);
        polynomial.getMonomials().put(2,4);
        polynomial.getMonomials().put(0,5);
        result = new Polynomial();
        result.getMonomials().put(4,0.25);
        result.getMonomials().put(3,1.3333334);
        result.getMonomials().put(1,5);
        assertEquals(Operations.Integrate(polynomial).toString(),result.toString());
    }
}
