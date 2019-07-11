package vapasi.share;

import java.util.List;
import java.util.Map;

class ShareValueCalculator {

    private List<Investment> investments;

    ShareValueCalculator(List<Investment> investments) {
        this.investments = investments;
    }

    String getStatus(Map<String, Integer> currentShareValues) {
        int purchasedShareValue = calculatePurchasedSharesValue();
        int currentShareValue = calculateCurrentSharesValue(currentShareValues);

        if (purchasedShareValue <= currentShareValue) {
            return "Profit " + (currentShareValue - purchasedShareValue);
        } else {
            return "Loss " + (purchasedShareValue - currentShareValue);
        }
    }

    private int calculatePurchasedSharesValue() {
        int totalShareValue = 0;
        for (Investment investment : investments) {
            totalShareValue += investment.getValue() * investment.getNoOfShares();
        }
        return totalShareValue;
    }

    private int calculateCurrentSharesValue(Map<String, Integer> newShareValues) {
        int totalShareValue = 0;
        for (Investment investment : investments) {
            totalShareValue += newShareValues.getOrDefault(investment.getName(), investment.getValue()) * investment.getNoOfShares();
        }
        return totalShareValue;
    }
}
