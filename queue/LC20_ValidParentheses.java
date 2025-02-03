package queue;
import java.util.*;
// LC20_ValidParentheses.java
// Source: https://leetcode.com/problems/valid-parentheses/

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//        An input string is valid if:
//
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Every close bracket has a corresponding open bracket of the same type.
//
//
//        Example 1:
//        Input: s = "()"
//        Output: true

//        Example 2:
//        Input: s = "()[]{}"
//        Output: true
//
//        Example 3:
//        Input: s = "(]"
//        Output: false
//
//        Example 4:
//        Input: s = "([])"
//        Output: true
//
//
//
//        Constraints:
//
//        1 <= s.length <= 104
//        s consists of parentheses only '()[]{}'.

public class LC20_ValidParentheses {
    public static void main(String[] args) {
        String example1 = "()[]{";
        boolean result1 = isValid(example1);
        System.out.printf("Input %s, Result: %s\n", example1, result1);

        String example2 = "()";
        boolean result2 = isValid(example2);
        System.out.printf("Input %s, Result: %s\n", example2, result2);

        String example3 = "(]";
        boolean result3 = isValid(example3);
        System.out.printf("Input %s, Result: %s\n", example3, result3);

        String example4 = "()";
        boolean result4 = isValid(example4);
        System.out.printf("Input %s, Result: %s\n", example4, result4);
    }

    public static boolean isValid(String s) {
        Map<Character, Character> openClosed = Map.of(
                '[', ']',
                '(', ')',
                '{', '}'
        );
        char[] charArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        if(charArr.length == 0 || charArr.length % 2 == 1) return false;
        for (char c : charArr) {
            if (openClosed.containsKey(c)) {
                stack.addLast(c);
            } else if (stack.isEmpty() ||openClosed.get(stack.removeLast())!= c) return false;
        }
        return stack.isEmpty();
    }
}
