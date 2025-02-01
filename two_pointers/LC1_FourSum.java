package two_pointers;
import java.util.*;

/**
 * LC1_FourSum.java
 * Source: <a href="https://leetcode.com/problems/4sum">...</a>
 *
 * Given an array nums of n integers, return an array of all unique quadruplets
 * [nums[a], nums[b], nums[c], nums[d]] such that:
 * - 0 <= a, b, c, d < n
 * - a, b, c, and d are distinct.
 * - nums[a] + nums[b] + nums[c] + nums[d] == target
 *
 * The solution uses sorting and a two-pointer approach for efficiency.
 *
 * Example 1:
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *
 * Example 2:
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 */
public class LC1_FourSum {
    public static void main(String[] args) {
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;
        int[][] expected1 = {{-2, -1, 1, 2}, {-2, 0, 0, 2}, {-1, 0, 0, 1}};
        List<List<Integer>> result1 = fourSum(nums1, target1);
        System.out.printf("Expected: %s\n", Arrays.toString(expected1));
        System.out.printf("Result: %s\n", result1);

        int[] nums2 = {2, 2, 2, 2, 2};
        int target2 = 8;
        int[][] expected2 = {{2, 2, 2, 2}};
        List<List<Integer>> result2 = fourSum(nums2, target2);
        System.out.printf("Expected: %s\n", Arrays.toString(expected2));
        System.out.printf("Result: %s\n", result2);
    }

    /**
     * Finds all unique quadruplets in the array that sum up to the given target.
     * The solution sorts the array and uses a two-pointer technique to efficiently
     * search for valid quadruplets while skipping duplicates.
     *
     * @param nums The input array
     * @param target The target sum
     * @return A list of unique quadruplets
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sorting is necessary for two-pointer technique

        for (int extLeft = 0; extLeft < nums.length - 2; extLeft++) {
            // Skip duplicates for the first element
            if (extLeft != 0 && nums[extLeft] == nums[extLeft - 1]) continue;

            for (int extRight = extLeft + 3; extRight < nums.length; extRight++) {
                // Optimization: Early termination if the smallest sum is already too large
                if ((long) nums[extLeft] + nums[extLeft + 1] + nums[extLeft + 2] + nums[extLeft + 3] > target) break;

                // Optimization: Skip iteration if the largest sum is too small
                if ((long) nums[extLeft] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) continue;

                // Skip duplicates for the last element
                if (extRight != nums.length - 1 && nums[extRight] == nums[extRight + 1]) continue;

                long sum = nums[extLeft] + nums[extRight];
                long findSum = target - sum;
                int intLeft = extLeft + 1;
                int intRight = extRight - 1;

                // Two-pointer search for the remaining two numbers
                while (intLeft < intRight) {
                    int intSum = nums[intLeft] + nums[intRight];

                    if (intSum == findSum) {
                        // Found a valid quadruplet
                        result.add(Arrays.asList(nums[extLeft], nums[intLeft], nums[intRight], nums[extRight]));

                        // Skip duplicate values for the left and right pointers
                        do { intLeft++; } while (intLeft < intRight && nums[intLeft] == nums[intLeft - 1]);
                        do { intRight--; } while (intLeft < intRight && nums[intRight] == nums[intRight + 1]);

                    } else if (intSum < findSum) {
                        // Move left pointer to increase sum
                        do { intLeft++; } while (intLeft < intRight && nums[intLeft] == nums[intLeft - 1]);

                    } else {
                        // Move right pointer to decrease sum
                        do { intRight--; } while (intLeft < intRight && nums[intRight] == nums[intRight + 1]);
                    }
                }
            }
        }
        return result;
    }
}
