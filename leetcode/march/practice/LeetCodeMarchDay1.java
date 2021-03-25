package leetcode.march.practice;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3657/
 */
public class LeetCodeMarchDay1 {
    public static void main(String[] args) {
        int[] input = {1,1,2,2,3,3};
        System.out.println("Input 1 = " + Candies.distributeCandies(input));
        int[] input1 = {1,1,2,3};
        System.out.println("Input 2 = " + Candies.distributeCandies(input1));
        int[] input2 = {6,6,6,6};
        System.out.println("Input 3 = " + Candies.distributeCandies(input2));
        int[] input3 = {1,2,1,1,2,1};
        System.out.println("Input 4 = " + Candies.distributeCandies(input3));
    }

    static class Candies {
        public static int distributeCandies(int[] candyType) {
            int res;
            int canEat = candyType.length / 2;
            res = Arrays.stream(candyType).distinct().toArray().length;
            if (res >= canEat) {
                res = canEat;
            }
            return res;
        }
    }
}
