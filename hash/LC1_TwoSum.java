package hash;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// LC1_TwoSum.java
// Source: https://leetcode.com/problems/two-sum/

// Given an array of integers nums and an integer target,
// return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution,
// and you may not use the same element twice.

// Example 1:
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//
// Example 2:
// Input: nums = [3,2,4], target = 6
// Output: [1,2]
//
// Example 3:
// Input: nums = [3,3], target = 6
// Output: [0,1]

// Constraints:
//  2 <= nums.length <= 10^4
//  -10^9 <= nums[i] <= 10^9
//  -10^9 <= target <= 10^9
//  Only one valid answer exists.

public class LC1_TwoSum {
    public static void main(String[] args) {
        int[] nums1 = {2,7,11,15};
        int target1 = 9;
        int[] expected1 = {0,1};
        int[] result1 = twoSum(nums1, target1);
        System.out.printf("Expected: %s\n", Arrays.toString(expected1));
        System.out.printf("Result: %s\n", Arrays.toString(result1));

        int[] nums2 = {3,2,4};
        int target2 = 6;
        int[] expected2 = {1,2};
        int[] result2 = twoSum(nums2, target2);
        System.out.printf("Expected: %s\n", Arrays.toString(expected2));
        System.out.printf("Result: %s\n", Arrays.toString(result2));

        int[] nums3 = {3,3};
        int target3 = 6;
        int[] expected3 = {0,1};
        int[] result3 = twoSum(nums3, target3);
        System.out.printf("Expected: %s\n", Arrays.toString(expected3));
        System.out.printf("Result: %s\n", Arrays.toString(result3));
    }

    public static int[] twoSum(int[] nums, int target) {
        // Step 1: Create a HashMap to store numbers and their indices
        Map<Integer, Integer> indexMap = new HashMap<>();

        // Step 2: Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Step 3: Check if the complement (target - nums[i]) exists in the map
            Integer secondIndex = indexMap.get(target - nums[i]);
            if (secondIndex != null) {
                return new int[]{i, secondIndex}; // Found the pair, return their indices
            }

            // Step 4: Store the current number with its index in the map
            indexMap.put(nums[i], i);
        }

        // Step 5: If no pair is found, return null (though problem guarantees an answer exists)
        return null;
    }
}
