package leetcode.march.practice;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3668/
 */
public class LeetCodeMarchDay11 {

    public static void main(String[] args) {
        System.out.println("Test 1: " + CoinChange.coinChange(new int[]{1,2,5},20));
        System.out.println("Test 2: " + CoinChange.coinChange(new int[]{1},0));
        System.out.println("Test 3: " + CoinChange.coinChange(new int[]{2},3));
        System.out.println("Test 4: " + CoinChange.coinChange(new int[] {186,419,83,408},6249));//20
        System.out.println("Test 5: " + CoinChange.coinChange(new int[]{1},2));//2
        System.out.println("Test 6 : " + CoinChange.coinChange(new int[]{384,324,196,481}, 285));//-1
    }

    static class CoinChange {
        public static int coinChange (int[] coins, int amount) {


            if (amount == 0) return 0;

            if (coins.length == 1) {
                if (amount < coins [0]) return -1;
                if (coins [0] < amount) {if (amount % coins [0] == 0) return amount / coins [0]; return -1;}
                if (coins [0] == amount) return 1;
            }

            int[] amtCoinMin = new int [amount + 1];

            for (int i = 1; i <= amount; i++) {
                amtCoinMin [i] = Integer.MAX_VALUE;

                for (int j = 0; j < coins.length; j++) {
                    if ( coins[j] <= i && amtCoinMin [i - coins [j]] != Integer.MAX_VALUE) {
                        amtCoinMin [i] = Integer.min(amtCoinMin [i], 1 + amtCoinMin [i - coins [j]]);
                    }
                }
            }

            return amtCoinMin [amount] == Integer.MAX_VALUE ? -1 : amtCoinMin [amount];

        }
    }
}
