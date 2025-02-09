package sliding_window;

import java.util.*;

// sliding_window.LC763_PartitionLabels.java
// Source: https://leetcode.com/problems/partition-labels
//You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
//
//        Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
//
//        Return a list of integers representing the size of these parts.
//
//        Example 1:
//        Input: s = "ababcbacadefegdehijhklij"
//        Output: [9,7,8]
//        Explanation:
//        The partition is "ababcbaca", "defegde", "hijhklij".
//        This is a partition so that each letter appears in at most one part.
//        A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
//        Example 2:
//        Input: s = "eccbbbbdec"
//        Output: [10]
//
//        Constraints:
//
//        1 <= s.length <= 500
//        s consists of lowercase English letters.
public  class LC763_PartitionLabels {

    public static void main(String[] args) {
//        String s1 = "ababcbacadefegdehijhklij";
//        List<Integer> result1 = partitionLabels(s1);
//        System.out.printf("Input %s, Result: %s\n", s1, Arrays.toString(result1.toArray()));
//
//        String s2 = "eccbbbbdec";
//        List<Integer> result2 = partitionLabels(s2);
//        System.out.printf("Input %s, Result: %s\n", s2, Arrays.toString(result2.toArray()));

        String s3 = "caedbdedda";
        List<Integer> result3 = partitionLabels(s3);
        System.out.printf("Input %s, Result: %s\n", s3, Arrays.toString(result3.toArray()));



    }
    public static List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<Integer>();
        int[] lastIndex = new int[26];
        for (int i=0; i<s.length(); i++){
            lastIndex[s.charAt(i)-'a'] = i;
        }
        int index = 0;
        while (index<s.length()){
            int maxIndex =  lastIndex[s.charAt(index)-'a'];
            int start = index;
            if(maxIndex == s.length()-1) {
                result.add(s.length()- index);
                return result;
            }
            if(maxIndex == index) {
                result.add(1);
                index++;
                continue;
            }
            while (index < maxIndex) {
                maxIndex = Math.max(maxIndex, lastIndex[s.charAt(index) - 'a']);
                index++;
            }
            result.add(index - start + 1);
            index++;

        }
        return result;
    }

}
