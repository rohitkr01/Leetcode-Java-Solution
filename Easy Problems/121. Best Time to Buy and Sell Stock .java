// First attempt - simple brute force solution (just coded up problem definition):
// O(n^2) time, O(1) space

public int maxProfit(int[] prices) {
    int profit = 0;
    for (int i = 0; i < prices.length; i++) {
        for (int j = i; j >= 0; j--) {
            profit = Math.max(profit, prices[i]-prices[j]);
        }
    }
    return profit;
}

//------------------------------------------------------------

/*Second attempt - tried to solve iterating over array two times:

first pass - from left to right and saving current minimum in additional array

second pass - from right to left finding maximum of current profit and previous maximum profit */

// O(n) time, O(n) space
 public int maxProfit(int[] prices) {
    int[] minPrices = new int[prices.length];
    int currentMinPrice = prices.length > 0 ? prices[0] : 0;
    for (int i = 0; i < prices.length; i++) {
        currentMinPrice = Math.min(currentMinPrice, prices[i]);
        minPrices[i] = currentMinPrice;
    } 
    int currentMaxPrice = prices.length > 0 ? prices[prices.length - 1] : 0;
    int profit = currentMaxPrice - currentMinPrice;
    for (int i = prices.length - 1; i >= 0 ; i--) {
        currentMaxPrice = Math.max(currentMaxPrice, prices[i]);
        profit = Math.max(profit, currentMaxPrice - minPrices[i]);
    }
    return profit;
}


// Third attempt - finally figured out, that keeping current minimum in separate array is really not required:
// O(n) time, O(1) space

public int maxProfit(int[] prices) {
    int currentMinPrice = prices.length > 0 ? prices[0] : 0;
    int profit = 0;
    for (int i = 0; i < prices.length; i++) {
        currentMinPrice = Math.min(currentMinPrice, prices[i]);
        profit = Math.max(profit, prices[i] - currentMinPrice); 
    }
    return profit;
}
