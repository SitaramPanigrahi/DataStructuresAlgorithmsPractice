package leetcode.march.practice;

import java.util.Arrays;

/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/588/week-1-march-1st-march-7th/3658/
 */
public class LeetCodeMarchDay2 {
    public static void main(String[] args) {
        int test1[] = {1,2,2,3};
        System.out.println("Test 1 = ");
        Arrays.stream(SetMismatch.findErrorNums(test1)).forEach(System.out::print);

        int test2[] = {1,1};
        System.out.println("\n Test 2 = ");
        Arrays.stream(SetMismatch.findErrorNums(test2)).forEach(System.out::print);

        int test3[] = {1,3,4,2,3};
        System.out.println("\n Test 3 = ");
        Arrays.stream(SetMismatch.findErrorNums(test3)).forEach(System.out::print);

        int test4[] = {1,4,2,4};
        System.out.println("\n Test 3 = ");
        Arrays.stream(SetMismatch.findErrorNums(test4)).forEach(System.out::print);
    }

    static class SetMismatch {
        public static int[] findErrorNums(int[] nums) {
            int[] res = new int[2];
            int maxSum = nums.length * (nums.length + 1) / 2;
            int inputArrSum = 0;

            for (int i = 0; i < nums.length; i++)
            {
                int val = nums [i];

                if ((i + 1) == nums [i])
                {
                    continue;
                }
                else if (nums [val - 1] != nums [i]) {
                    int temp = nums [val - 1];
                    nums [val - 1] = nums [i];
                    nums [i] = temp;
                    i--;
                }
                else if (nums [val - 1] == nums [i]) {
                    res [0] = nums [i];
                }
            }

            for (int i = 0;i < nums.length; i++) {
                inputArrSum += nums [i];
            }

            res [1] = res [0] + (maxSum - inputArrSum);

            return res;
        }
    }
}
