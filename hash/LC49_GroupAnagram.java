package hash;
import java.util.*;
// LC49_GroupAnagram.java
// Source: https://leetcode.com/problems/group-anagrams/

// Given an array of strings strs, group the anagrams together.
// You can return the answer in any order.
//
// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
// Explanation:
// "bat" has no anagram in strs.
// "nat" and "tan" are anagrams since they can be rearranged to form each other.
// "ate", "eat", and "tea" are anagrams as well.

public class LC49_GroupAnagram {

    public static void main(String[] args) {
        // Example input array
        String[] sList = {"eat", "tea", "tan", "ate", "nat", "bat"};

        // Call the method and print result
        System.out.println(groupAnagrams(sList));
    }

    public static List<List<String>> groupAnagrams(String[] words) {
        // HashMap to store sorted word as key and list of original words as value
        Map<String, List<String>> wordMap = new HashMap<>();

        for (String word : words) {
            String sortedWord = sortWords(word); // Get sorted version of the word

            // If key does not exist, create a new list
            wordMap.putIfAbsent(sortedWord, new ArrayList<>());

            // Add original word to the corresponding anagram group
            wordMap.get(sortedWord).add(word);
        }

        // Return all grouped anagrams
        return new ArrayList<>(wordMap.values());
    }


    private static String sortWords(String word) {
        if (word == null || word.length() < 2) return word; // Edge case: null or single-letter words

        // Convert string to char array, sort it, and return new sorted string
        char[] sortedChar = word.toCharArray();
        Arrays.sort(sortedChar);
        return String.valueOf(sortedChar);
    }
}
