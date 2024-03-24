class Solution {
  public int maxProfit(int[] prices) {
    // int maxProfit = 0;

    // for (int i = 0; i < prices.length; i++) {
    //   for (int j = i + 1; j < prices.length; j++) {
    //     int profit = prices[j] - prices[i];
    //     if (profit > maxProfit) {
    //       maxProfit = profit;
    //     }
    //   }
    // }

    // return maxProfit;

    int maxProfit = 0;
    int buyDate = 0;
    int sellDate = 1;
    int profit;

    for (int i = 0; i < prices.length - 1; i++) {
      profit = prices[sellDate] - prices[buyDate];
      if (profit > maxProfit) {
        maxProfit = profit;
      }
      if (profit < 0) {
        buyDate = sellDate;
      }
      sellDate++;
    }

    return maxProfit;
  }
}
