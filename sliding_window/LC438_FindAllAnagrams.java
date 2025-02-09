package sliding_window;
// sliding_window.LC438_FindAllAnagrams
// Source: leetcode.com/problems/find-all-anagrams-in-a-strin

import java.util.*;

//Given two strings s and p, return an array of all the start indices of p's
//        anagrams
//        in s. You may return the answer in any order.
//
//
//
//        Example 1:
//
//        Input: s = "cbaebabacd", p = "abc"
//        Output: [0,6]
//        Explanation:
//        The substring with start index = 0 is "cba", which is an anagram of "abc".
//        The substring with start index = 6 is "bac", which is an anagram of "abc".
//        Example 2:
//
//        Input: s = "abab", p = "ab"
//        Output: [0,1,2]
//        Explanation:
//        The substring with start index = 0 is "ab", which is an anagram of "ab".
//        The substring with start index = 1 is "ba", which is an anagram of "ab".
//        The substring with start index = 2 is "ab", which is an anagram of "ab".
//
//
//        Constraints:
//
//        1 <= s.length, p.length <= 3 * 104
//        s and p consist of lowercase English letters.
public  class LC438_FindAllAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        int[] currentCount = new int[26];
        Map<Integer, Integer> findCount = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (char c : p.toCharArray()) {
            findCount.compute(c-'a', (k,v)-> v==null? 1 : v++);
        }

        for (int i = 0; i < s.length() - p.length()+1; i++) {
            for (int j = 0; j < p.length(); j++) {
                int ind =  s.charAt(i + j) - 'a';
                if (!findCount.containsKey(ind) || findCount.get(ind)<currentCount[ind]+1 ) {
                    continue;
                }
                currentCount[ind]++;
            }
            if(checkResult(currentCount, findCount))
            result.add(i);
            currentCount[s.charAt(i) - 'a']--;
          }
        return result;
    }

    static boolean  checkResult(int[] currentCount, Map<Integer, Integer> findCount){
        for(Map.Entry<Integer,Integer> entry: findCount.entrySet()) {
            int ind =  entry.getKey();
            int val =  entry.getValue();
            if(currentCount[ind] != val) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "cbaebabacd";
        String p1 = "abc";

        List<Integer> result1 = findAnagrams (s1, p1);
        System.out.printf("Input %s,%s, Result: %s\n", s1,p1, Arrays.toString(result1.toArray()));


        String s2 = "baa";
        String p2 = "aa";
        List<Integer> result2 = findAnagrams (s2, p2);
        System.out.printf("Input %s,%s, Result: %s\n", s2,p2, Arrays.toString(result2.toArray()));

    }
}
