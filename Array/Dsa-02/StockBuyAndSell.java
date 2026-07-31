

//Minimum So Far Pattern
public class StockBuyAndSell {

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minValue = prices[0];

        for(int i=1 ; i<prices.length ; i++){
            minValue = Math.min(minValue,prices[i]);
            int profit = prices[i] - minValue;
            maxProfit = Math.max(maxProfit,profit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = maxProfit(prices);

        System.out.println("Maximum Profit: " + result);
    }
}

// minPrice = minimum price seen so far

// profit = currentPrice - minPrice

// maxProfit = maximum(maxProfit, profit)