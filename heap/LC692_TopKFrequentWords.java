package heap;

import java.util.*;
// heap.LC692_TopKFrequentWords.java
// Source: https://https://leetcode.com/problems/top-k-frequent-words

//    Given an array of strings words and an integer k, return the k most frequent strings.
//    Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
//    Given an array of strings words and an integer k, return the k most frequent strings.
//    Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical orderExample 1:
//    Example 1:
//      Input: words = ["i","love","leetcode","i","love","coding"], k = 2
//      Output: ["i","love"]
//      Explanation: "i" and "love" are the two most frequent words.
//
//     Example 2:
//      Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
//      Output: ["the","is","sunny","day"]
//      Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
public class LC692_TopKFrequentWords {
    public static void main(String[] args) {
        // Implementation goes here
        String[] example1 = new String[]{"i","love","leetcode","i","love","coding"};
        List<String> expected1 = Arrays.asList("i", "love");
        List<String> result1 = topKFrequent(example1, 2);

        String[] example2 = new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"};
        List<String> expected2 = Arrays.asList("the", "is", "sunny", "day");
        List<String> result2 = topKFrequent(example2, 4);

        assert result1.equals(expected1) : "Test case 1 failed";
        assert result2.equals(expected2) : "Test case 2 failed";

        System.out.println("All test cases passed!");
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();

        System.out.printf("Input : %s, k = %s%n", Arrays.toString(words), k);
        Map<String, Integer> frequentMap = new HashMap<>();
            for (String word : words){
            frequentMap.compute(word, (s, integer) -> integer == null ? 1 : integer + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((o1, o2) ->
                o1.getValue().equals(o2.getValue()) ? o2.getKey().compareTo(o1.getKey()) : Integer.compare(o1.getValue(), o2.getValue()));
        frequentMap.entrySet().forEach(entry ->
        {   minHeap.add(entry);
            if (minHeap.size()>k) minHeap.poll();
        });

            while (!minHeap.isEmpty()){
            result.add(minHeap.poll().getKey());
        }

        List<String> returnResult = result.reversed();
        System.out.printf("Output : %s%n", Arrays.toString(returnResult.toArray()));

        return returnResult;
    }
}
