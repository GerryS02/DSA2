// Given an array prices of n integers, where prices[i] represents price of the stock on the ith day.
// Determine the maximum profit achievable by buying and selling the stock at most once. 

// The stock should be purchased before selling it, and both actions cannot occur on the same 
// day.

public class Solution {
    public int stockBuySell(int[] prices){
        int profit = 0;
        int minPrice = prices[0];

        for(int price : prices){
            if(price < minPrice){
                minPrice = price;
            }

            profit = Math.max(profit, price - minPrice);
        }

        return profit;
    }
}
