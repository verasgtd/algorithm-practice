package two_pointers;

import java.util.Arrays;

/**
 * LC309_BestTime2BuyAndSellStockWithCooldown.java
 * Source: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown">...</a>
 **/
//You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//        Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
//
//        After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
//        Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
//
//
//
//        Example 1:
//
//        Input: prices = [1,2,3,0,2]
//        Output: 3
//        Explanation: transactions = [buy, sell, cooldown, buy, sell]
//
//        Example 2:
//        Input: prices = [1]
//        Output: 0
//
//
//        Constraints:
//
//        1 <= prices.length <= 5000
//        0 <= prices[i] <= 1000
public class LC309_BestTime2BuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,2};
        int expected1 = 3;
        int result1 = maxProfit(nums1);
        System.out.printf("Input: %s, Expected %s, Result %s \n", Arrays.toString(nums1), expected1, result1);

        int[] nums2 = {1};
        int expected2 = 0;
        int result2 = maxProfit(nums2);
        System.out.printf("Input: %s, Expected %s, Result %s \n", Arrays.toString(nums2), expected2, result2);
    }

    public  static int maxProfit(int[] prices) {
        int size = prices.length;
        if(size<2) return 0;
        if(size==2) return Math.max(prices[1]-prices[0], 0);
        int sell = 0; // Maximum profit when NOT holding a stock
        int buy = Integer.MIN_VALUE; // Maximum profit when HOLDING a stock
        int cooldown = 0; // Maximum profit when HOLDING a stock
        // Iterate through each day's price
        for (int i = 0; i < size; i++) {
            int prevSell = sell; // Store previous cash for cooldown update
            // Calculate the best case if we decide to sell today
            sell = Math.max(sell, buy + prices[i]);

            // Calculate the best case if we decide to buy today
            buy = Math.max(buy, cooldown - prices[i]);

            cooldown = prevSell;
        }
        return sell; // The final maximum profit without holding stocks
    }
}
