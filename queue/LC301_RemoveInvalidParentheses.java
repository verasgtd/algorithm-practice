package queue;

import java.util.*;
import java.util.stream.Collectors;

import static queue.LC20_ValidParentheses.isValid;
// LC301_ValidParentheses.java
// Source: https://leetcode.com/problems/remove-invalid-parentheses/

//Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
//
//        Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.
//
//
//        Example 1:
//        Input: s = "()())()"
//        Output: ["(())()","()()()"]
//
//        Example 2:
//        Input: s = "(a)())()"
//        Output: ["(a())()","(a)()()"]
//
//        Example 3:
//        Input: s = ")("
//        Output: [""]


public class LC301_RemoveInvalidParentheses {

    public record Pair(int removeLeft, int removeRight) {}

    public static void main(String[] args) {
        String example1 = "((((((((((((((((((aaaaa))";
        List<String> result1 = removeInvalidParentheses (example1);
        System.out.printf("Input %s, Result: %s\n", example1, Arrays.toString(result1.toArray()));

        String example2 = "(a)())()";
        List<String> result2 = removeInvalidParentheses (example1);
        System.out.printf("Input %s, Result: %s\n", example2, Arrays.toString(result2.toArray()));

        String example3 = ")(";
        List<String> result3 = removeInvalidParentheses (example2);
        System.out.printf("Input %s, Result: %s\n", example3, Arrays.toString(result3.toArray()));

        String example4 = "((((((((((((((((((aaaaa))";
        List<String> result4 = removeInvalidParentheses (example2);
        System.out.printf("Input %s, Result: %s\n", example3, Arrays.toString(result4.toArray()));
    }

    public static List<String> removeInvalidParentheses (String s) {
        Set<String>result= new HashSet<>();
        Pair removeRightLeft = getRemoveCounts( s);

        Set<String> checkDuplicates = new HashSet<>();
        collectValidStr( s,  result, removeRightLeft.removeRight, removeRightLeft.removeLeft, checkDuplicates);

        return result.stream().toList();
    }


    public static void collectValidStr(String s, Set<String> result ,int removeRight, int removeLeft, Set<String> checkDuplicates) {
        if (checkDuplicates.contains(s)) return;
        if (removeRight==0 && removeLeft==0){
            if (isValid( s)) result.add(s);
            return ;
        }
        int n = s.length();
        checkDuplicates.add(s);
        char c = ' ';
        if(removeLeft!=0) {
            removeLeft--;
            for(int i=0; i<n; i++){
                if (s.charAt(i)== '('){
                    String newS = s.substring(0, i) + s.substring(i+1, n);
                    collectValidStr(newS, result, removeRight, removeLeft, checkDuplicates);
                }
            }
        }
        if(removeRight!=0) {
            removeRight--;
            for(int i=0; i<n; i++){
                if (s.charAt(i)== ')'){
                    String newS = s.substring(0, i) + s.substring(i+1, n);
                    collectValidStr(newS, result, removeRight, removeLeft, checkDuplicates);
                }
            }
        }

    }


        public static boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;

            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0) return false;
        }
        return  (count == 0);
    }

    public static Pair getRemoveCounts(String s) {
        int removeRight = 0;
        int removeLeft = 0;
        int count = 0;

        for (char c : s.toCharArray()) {
            count = c == '(' ? count+1 : count-1;
            if (count < 0) {
                removeRight++;
                count = 0;
            }
        }
        removeLeft = count;

        return new Pair(removeLeft, removeRight);
    }
}
