import org.example.Controller;
import org.example.Polinom;
import org.example.View;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperationsTest {
    @Test
    public void addTest(){
        View view = new View();
        Controller controller = new Controller(view);
        String aSir = "5x^6-7x^7+4x^2-9+x";
        String bSir = "3+x^2";
        Polinom a = controller.makeThePolinoms(aSir);
        Polinom b = controller.makeThePolinoms(bSir);
        assertEquals(a.add(b).afisareString(),"-7.0x^7+5.0x^6+5.0x^2+1.0x-6.0");
    }
    @Test
    public void substractTest(){
        View view = new View();
        Controller controller = new Controller(view);
        String aSir = "5x^6-7x^7+4x^2-9+x";
        String bSir = "3+x^2";
        Polinom a = controller.makeThePolinoms(aSir);
        Polinom b = controller.makeThePolinoms(bSir);
        assertEquals(a.substract(b).afisareString(),"-7.0x^7+5.0x^6+3.0x^2+1.0x-12.0");
    }
    @Test
    public void multiplyTest(){
        View view = new View();
        Controller controller = new Controller(view);
        String aSir = "5x^6-7x^7+4x^2-9+x";
        String bSir = "3+x^2";
        Polinom a = controller.makeThePolinoms(aSir);
        Polinom b = controller.makeThePolinoms(bSir);
        assertEquals(a.multiply(b).afisareString(),"-7.0x^9+5.0x^8-21.0x^7+15.0x^6+4.0x^4+1.0x^3+3.0x^2+3.0x-27.0");
    }
    @Test
    public void divideTest(){
        View view = new View();
        Controller controller = new Controller(view);
        String aSir = "5x^6-7x^7+4x^2-9+x";
        String bSir = "7+x";
        Polinom a = controller.makeThePolinoms(aSir);
        Polinom b = controller.makeThePolinoms(bSir);
        assertEquals(a.divide(b),"-7.0x^6+54.0x^5-378.0x^4+2646.0x^3-18522.0x^2+129658.0x-907605.0+(+6353226.0)/(+1.0x+7.0)");
    }
    @Test
    public void integralTest(){
        View view = new View();
        Controller controller = new Controller(view);
        String aSir = "5x^6-7x^7+4x^2-9+x";
        Polinom a = controller.makeThePolinoms(aSir);
        assertEquals(a.integral().afisareString(),"-0.875x^8+0.7142857142857143x^7+1.3333333333333333x^3+0.5x^2-9.0x");
    }
    @Test
    public void derivativeTest(){
        View view = new View();
        Controller controller = new Controller(view);
        String aSir = "5x^6-7x^7+4x^2-9+x";
        Polinom a = controller.makeThePolinoms(aSir);
        assertEquals(a.derivative().afisareString(),"-49.0x^6+30.0x^5+8.0x+1.0");
    }
}
