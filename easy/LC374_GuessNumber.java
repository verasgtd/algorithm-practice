package easy;

import java.util.Random;


// Source: https://leetcode.com/problems/valid-parentheses/

//We are playing the Guess Game. The game is as follows:
//
//        I pick a number from 1 to n. You have to guess which number I picked.
//
//        Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
//
//        You call a pre-defined API int guess(int num), which returns three possible results:
//
//        -1: Your guess is higher than the number I picked (i.e. num > pick).
//        1: Your guess is lower than the number I picked (i.e. num < pick).
//        0: your guess is equal to the number I picked (i.e. num == pick).
//        Return the number that I picked.
//
//
//
//        Example 1:
//
//        Input: n = 10, pick = 6
//        Output: 6
//        Example 2:
//
//        Input: n = 1, pick = 1
//        Output: 1
//        Example 3:
//
//        Input: n = 2, pick = 1
//        Output: 1
//
//
//        Constraints:
//
//        1 <= n <= 231 - 1
//        1 <= pick <= n

public class LC374_GuessNumber {

    public static int randomPick;
    public static void main(String[] args) {
        int n1 = 10;
        setRandomPick(n1);
        int pick1 = guessNumber(n1);
        System.out.printf("Input %s, Random= %s, Result=%s\n", n1, randomPick, pick1);

        int n2 = 100;
        setRandomPick(n2);
        int pick2 = guessNumber(n2);
        System.out.printf("Input %s, Random= %s, Result=%s\n", n2, randomPick, pick2);

    }

    public static int guessNumber(int n) {
        return guessNumber(0, n);
    }

    public static int guessNumber(int start, int end) {
        if(start == end) return start;
        int pick = start + (end-start)/2;
        int result = guess(pick);
        if(result==0) return pick;
        if(result>0) return guessNumber(pick+1, end);
        return guessNumber(start, pick);
    }

    private static  int guess(int pick) {
        return randomPick-pick;
    }

    public static void setRandomPick(int max) {
        Random random= new Random();
        randomPick = random.nextInt(max);
    }

}
