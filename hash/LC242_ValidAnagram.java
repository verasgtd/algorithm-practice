package hash;
// LC242_ValidAnagram.java
// Source: https://leetcode.com/problems/valid-anagram/

// Given two strings s and t, return true if t is an anagram
// of s, and false otherwise.

import java.util.Objects;

// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true
//
// Example 2:
// Input: s = "rat", t = "car"
// Output: false
// Constraints:
//  1 <= s.length, t.length <= 5 * 10^4
//  s and t consist of lowercase English letters.
public class LC242_ValidAnagram {
    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";

        boolean expected1 = true;
        boolean result1 = isAnagram(s1, t1);
        System.out.printf("Expected: %s\n", expected1);
        System.out.printf("Result: %s\n", result1);

        String s2 = "rat";
        String t2 = "car";

        boolean expected2 = false;
        boolean result2 = isAnagram(s2, t2);
        System.out.printf("Expected: %s\n", expected2);
        System.out.printf("Result: %s\n", result2);
    }

    public static boolean isAnagram(String s, String t) {
        // Step 1: Check for null values and quick reference check
        if (Objects.equals(s, t)) {
            return true;
        }

        if (s != null && t != null) {
            // Step 2: If lengths are different, they cannot be anagrams
            if (s.length() != t.length()) {
                return false;
            }

            // Step 3: Use an array of size 26 to store character frequencies
            int[] frequencyArr = new int[26];

            // Step 4: Count frequency of each character in string s
            for (char ch : s.toCharArray()) {
                frequencyArr[ch - 'a']++;
            }

            // Step 5: Decrease frequency for each character in string t
            for (char ch : t.toCharArray()) {
                if (frequencyArr[ch - 'a'] == 0) return false; // If character count goes negative, return false
                frequencyArr[ch - 'a']--;
            }

            // Step 6: If all counts are zero, it's an anagram
            return true;
        }
        return false;
    }
}