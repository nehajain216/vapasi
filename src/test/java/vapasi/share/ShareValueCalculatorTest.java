package vapasi.share;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ShareValueCalculatorTest {

    private ShareValueCalculator calculator;

    @Before
    public void setup()
    {
        List<ShareValue> shares = new ArrayList<>();
        ShareValue jp = new ShareValue("JP",400,3);
        ShareValue mg = new ShareValue("MG",300,1);
        ShareValue tm = new ShareValue("TM",200,5);
        ShareValue a2b = new ShareValue("A2B",100,10);
        shares.add(jp);
        shares.add(mg);
        shares.add(tm);
        shares.add(a2b);
        calculator = new ShareValueCalculator(shares);
    }
    @Test
    public void shouldReturnProfit()
    {
        Map<String,Integer> newValues = new HashMap<>();
        newValues.put("JP",200);
        newValues.put("MG",500);
        newValues.put("A2B",150);

        String status = calculator.getStatus(newValues);
        assertEquals("Profit 100",status);
    }

    @Test
    public void shouldReturnLoss()
    {
        Map<String,Integer> newValues = new HashMap<>();
        newValues.put("TM",100);
        newValues.put("MG",500);
        newValues.put("JP",400);

        String status = calculator.getStatus(newValues);
        assertEquals("Loss 300",status);
    }

    @Test
    public void shouldReturnZeroProfit()
    {
        Map<String,Integer> newValues = new HashMap<>();
        newValues.put("TM",200);
        newValues.put("MG",300);
        newValues.put("JP",400);
        newValues.put("A2B",100);

        String status = calculator.getStatus(newValues);
        assertEquals("Profit 0",status);
    }

    @Test
    public void shouldReturnZeroProfitWhenNoChanges()
    {
        Map<String,Integer> newValues = new HashMap<>();

        String status = calculator.getStatus(newValues);
        assertEquals("Profit 0",status);
    }

    @Test
    public void shouldReturnStatusIgnoringUnrecognisedShares()
    {
        Map<String,Integer> newValues = new HashMap<>();
        newValues.put("TM",200);
        newValues.put("MG",300);
        newValues.put("JP",400);
        newValues.put("XYZ",100); // Unknown share name

        String status = calculator.getStatus(newValues);
        assertEquals("Profit 0",status);
    }

}