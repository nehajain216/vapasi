package vapasi.share;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class JPShareCalculatorTest {

    private JPShareCalculator calculator;

    @Test
    public void shouldReturnProfit() {
        List<Investment> investments = new ArrayList<>();
        Investment share1 = new Investment(600, 3);
        Investment share2 = new Investment(600, 1);
        Investment share3 = new Investment(300, 2);

        investments.add(share1);
        investments.add(share2);
        investments.add(share3);

        calculator = new JPShareCalculator(investments);
        String status = calculator.getStatus();
        assertEquals("profit: 600", status);
    }

    @Test
    public void shouldReturnLoss() {
        List<Investment> investments = new ArrayList<>();
        Investment share1 = new Investment(100, 3);
        Investment share2 = new Investment(200, 1);
        Investment share3 = new Investment(300, 2);

        investments.add(share1);
        investments.add(share2);
        investments.add(share3);

        calculator = new JPShareCalculator(investments);
        String status = calculator.getStatus();
        assertEquals("Loss: 1300", status);
    }

    @Test
    public void shouldReturnProfitForEqualValues() {
        List<Investment> investments = new ArrayList<>();
        Investment share1 = new Investment(200, 3);
        Investment share2 = new Investment(400, 1);
        Investment share3 = new Investment(700, 2);

        investments.add(share1);
        investments.add(share2);
        investments.add(share3);

        calculator = new JPShareCalculator(investments);
        String status = calculator.getStatus();
        assertEquals("profit: 0", status);
    }

}