package vapasi.share;

import java.util.*;

public class JPShareCalculator {
    int  shareCount=0;
    final static int actualShare = 400;
    private List<Investment> investments;


    public JPShareCalculator(List<Investment> investments) {
        this.investments = investments;
    }

    /*public static void main(String[] args) {
        // Sold share values
        investments = new ArrayList<>();
        Investment share1 = new Investment(100,3);
        Investment share2 = new Investment(200,1);
        Investment share3 = new Investment(300,2);

        investments.add(share1);
        investments.add(share2);
        investments.add(share3);

        System.out.println(getStatus());
    }*/

    String getStatus()
    {
        int soldShareValue = getSoldShareValue();
        int actualShareValue= getActualShareValue();
        if(soldShareValue>=actualShareValue)
            return "profit: "+ (soldShareValue-actualShareValue);
        else
            return "Loss: "+ (actualShareValue-soldShareValue);
    }

    private int getSoldShareValue()
    {
        int soldShareValue = 0;
        for (Investment inv :
                investments) {
            soldShareValue += inv.getValue()*inv.getNoOfShares();
            shareCount +=  inv.getNoOfShares();
        }
        return soldShareValue;
    }

    private int getActualShareValue()
    {
        return (actualShare*shareCount);
    }
}
