package two_pointers;

import java.util.Arrays;

/**
 * LC1_FourSum.java
 * Source: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee">...</a>
 **/
//You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
//
//        Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
//
//        Note:
//
//        You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
//        The transaction fee is only charged once for each stock purchase and sale.
//
//        Example 1:
//        Input: prices = [1,3,2,8,4,9], fee = 2
//        Output: 8
//        Explanation: The maximum profit can be achieved by:
//        - Buying at prices[0] = 1
//        - Selling at prices[3] = 8
//        - Buying at prices[4] = 4
//        - Selling at prices[5] = 9
//        The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
//
//        Example 2:
//        Input: prices = [1,3,7,5,10,3], fee = 3
//        Output: 6
public class LC714_BestTime2BuyAndSellStockWithFee {
    public static void main(String[] args) {
        int[] nums1 = {1,3,2,8,4,9};
        int expected1 = 8;
        int fee1 = 2;
        int result1 = maxProfit(nums1, fee1);
        System.out.printf("Input: %s, fee =%s, Expected %s, Result %s \n", Arrays.toString(nums1), fee1, expected1, result1);

        int[] nums2 = {1,3,7,5,10,3};
        int expected2 = 6;
        int fee2 = 3;
        int result2 = maxProfit(nums2, fee2);
        System.out.printf("Input: %s, fee =%s, Expected %s, Result %s \n", Arrays.toString(nums2), fee2, expected2, result2);

        int[] nums3 = {1,5,9};
        int expected3 = 6;
        int fee3 = 2;
        int result3 = maxProfit(nums3, fee3);
        System.out.printf("Input: %s, fee =%s, Expected %s, Result %s \n", Arrays.toString(nums3), fee3, expected3, result3);


    }

    public  static int maxProfit(int[] prices, int fee) {
        int size = prices.length;
        if(size<2) return 0;
        if(size==2) return Math.max(prices[1]-prices[0], 0);
        int sell = 0; // Maximum profit when NOT holding a stock
        int buy = Integer.MIN_VALUE; // Maximum profit when HOLDING a stock
        // Iterate through each day's price
        for (int i = 0; i < size; i++) {
            // Calculate the best case if we decide to sell today
            sell = Math.max(sell, buy + prices[i]);

            // Calculate the best case if we decide to buy today
            buy = Math.max(buy, sell - prices[i] - fee);
        }

        return sell; // The final maximum profit without holding stocks
    }
}
