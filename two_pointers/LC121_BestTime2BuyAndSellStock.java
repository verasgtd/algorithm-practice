package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC1_FourSum.java
 * Source: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">...</a>
 **/
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//
// Example 1:
// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 //
// Example 2:
// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done and the max profit = 0.
//
// Constraints:
//
// 1 <= prices.length <= 105
// 0 <= prices[i] <= 104
public class LC121_BestTime2BuyAndSellStock {
    public static void main(String[] args) {
        int[] nums1 = {7,1,5,3,6,4};
        int expected1 = 5;
        int result1 = maxProfit(nums1);
        System.out.printf("Input: %s, Expected %s, Result %s \n", Arrays.toString(nums1), expected1, result1);

        int[] nums2 = {7,6,4,3,1};
        int expected2 = 0;
        int result2 = maxProfit(nums2);
        System.out.printf("Input: %s, Expected %s, Result %s \n", Arrays.toString(nums2), expected2, result2);

    }

    public  static int maxProfit(int[] prices) {
        int size = prices.length;
        if(size<2) return 0;
        int minPriceSoFar = prices[0];
        int maxProfit = 0;
        for( int i=0; i<size; i++){
            if(prices[i]<minPriceSoFar )  minPriceSoFar = prices[i];
            if(prices[i] - minPriceSoFar> maxProfit)  maxProfit = prices[i] - minPriceSoFar;
        }
        return maxProfit;
    }
}
