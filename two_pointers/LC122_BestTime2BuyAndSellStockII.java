package two_pointers;

import java.util.Arrays;

/**
 * LC1_FourSum.java
 * Source: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii">...</a>
 **/
//You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
//
//        On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
//
//        Find and return the maximum profit you can achieve.

//        Example 1:
//        Input: prices = [7,1,5,3,6,4]
//        Output: 7
//        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//        Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//        Total profit is 4 + 3 = 7.
//
//        Example 2:
//        Input: prices = [1,2,3,4,5]
//        Output: 4
//        Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//        Total profit is 4.
//
//        Example 3:
//        Input: prices = [7,6,4,3,1]
//        Output: 0
//        Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
public class LC122_BestTime2BuyAndSellStockII {
    public static void main(String[] args) {
        int[] nums1 = {7,1,5,3,6,4};
        int expected1 = 7;
        int result1 = maxProfit(nums1);
        System.out.printf("Input: %s, Expected %s, Result %s \n", Arrays.toString(nums1), expected1, result1);

        int[] nums2 = {1,2,3,4,5};
        int expected2 = 4;
        int result2 = maxProfit(nums2);
        System.out.printf("Input: %s, Expected %s, Result %s \n", Arrays.toString(nums2), expected2, result2);

        int[] nums3 = {7,6,4,3,1};
        int expected3 = 0;
        int result3 = maxProfit(nums3);
        System.out.printf("Input: %s, Expected %s, Result %s \n", Arrays.toString(nums3), expected3, result3);

    }

    public  static int maxProfit(int[] prices) {
        int size = prices.length;
        if(size<2) return 0;
        if(size==2) return Math.max(prices[1]-prices[0], 0);

        int sumProfit = 0;
        int buyPrice = 0;
        for( int i=0; i<size; i++){
            while(i+1<size && prices[i]>=prices[i+1]) i++;
            buyPrice = prices[i];
            while(i+1<size && prices[i]<prices[i+1]) { i++;}
            if(i<size) sumProfit+=prices[i]-buyPrice;
        }
        return sumProfit;
    }
}
