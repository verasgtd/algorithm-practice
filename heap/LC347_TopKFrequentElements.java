package heap;
import java.util.*;
// LC347_TopKFrequentElements.java
// Source: https://leetcode.com/problems/top-k-frequent-elements/

// Given an integer array nums and an integer k, return the k most frequent elements.
// You may return the answer in any order.

// Example 1:
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
//
// Example 2:
// Input: nums = [1], k = 1
// Output: [1]
public class LC347_TopKFrequentElements {
    public static void main(String[] args) {
        int[] example1 = {1,1,1,2,2,3};
        int[] expected1 = {1,2};
        int[] result1 = topKFrequent(example1, 2);
        System.out.printf("Expected: %s\n", Arrays.toString(expected1));
        System.out.printf("Result: %s\n", Arrays.toString(result1));


        int[] example2 = {1};
        int[] expected2 = {1};
        int[] result2 =topKFrequent(example2, 1);
        System.out.printf("Expected: %s\n", Arrays.toString(expected2));
        System.out.printf("Result: %s\n", Arrays.toString(result2));

    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        // Step 1: Count the frequency of each number using a HashMap
        Map<Integer, Integer> frequentMap = new HashMap<>();
        for (Integer number : nums) {
            // Increment the frequency count for each number
            frequentMap.compute(number, (num, frequency) -> frequency == null ? 1 : frequency + 1);
        }

        // Step 2: Use a max heap (PriorityQueue) to store numbers sorted by their frequency
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((s1, s2) -> Integer.compare(s2.getValue(), s1.getValue()));
        frequentMap.entrySet().forEach(maxHeap::add);

        // Step 3: Extract the top k elements from the heap
        for (var i = 0; i < k; i++) {
            // Remove and store the most frequent elements from the heap
            result[i] = Objects.requireNonNull(maxHeap.poll()).getKey();
        }

        // Debugging output to verify correctness
        System.out.printf("Input: %s, k = %s, Output: %s\n", Arrays.toString(nums), k, Arrays.toString(result));

        return result;
    }
}
