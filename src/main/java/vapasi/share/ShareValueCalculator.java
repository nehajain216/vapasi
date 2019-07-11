package vapasi.share;

import java.util.List;
import java.util.Map;

public class ShareValueCalculator {

    private List<ShareValue> shares;

    ShareValueCalculator(List<ShareValue> shares) {
        this.shares = shares;
    }

    String getStatus(Map<String, Integer> newValues) {
        // return profit or Loss value

        int actualShareValue = calculatePurchasedSharesValue();
        int changedShareValue = calculateCurrentSharesValue(newValues);

        if(actualShareValue <= changedShareValue)
        {
            return "Profit "+ (changedShareValue-actualShareValue);
        }
        else
        {
            return "Loss "+ (actualShareValue-changedShareValue);
        }
    }

    private int calculatePurchasedSharesValue()
    {
        // calculate total share value of actual shares

        int actualShareValue = 0;
        for (ShareValue share : shares) {
            actualShareValue += share.getValue()*share.getNoOfShares();
        }
        return actualShareValue;
    }

    private int calculateCurrentSharesValue(Map<String, Integer> newShares)
    {
        // calculate total share value of changed shares
        int changedShareValue=0;
        for (ShareValue S :shares)
        {
            changedShareValue += newShares.getOrDefault(S.getName(),S.getValue())*S.getNoOfShares();
        }
        return changedShareValue;
    }
}
