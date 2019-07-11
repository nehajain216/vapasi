package vapasi.share;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) {

        List<ShareValue> shares = new ArrayList<>();
        ShareValue jp = new ShareValue("JP",400,3);
        ShareValue mg = new ShareValue("MG",300,1);
        ShareValue tm = new ShareValue("TM",200,5);
        ShareValue a2b = new ShareValue("A2B",100,10);
        shares.add(jp);
        shares.add(mg);
        shares.add(tm);
        shares.add(a2b);
        ShareValueCalculator calculator = new ShareValueCalculator(shares);

        Map<String,Integer> newValues = new HashMap<>();
        newValues.put("JP",200);
        newValues.put("MG",500);
        newValues.put("A2B",150);

       /* newValues.put("TM",100);
        newValues.put("MG",500);
        newValues.put("JP",400);*/

        String status = calculator.getStatus(newValues);
        System.out.println(status);
    }
}
