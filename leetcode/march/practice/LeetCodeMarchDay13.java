package leetcode.march.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
TREE, MATHS, DP : https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3670/

 */
public class LeetCodeMarchDay13 {

    public static void main(String[] args) {
        int arr[] = {2,4,8};
        System.out.println("Test 1 = " + BinaryTreeWithTwoFactors.numFactoredBinaryTrees(arr));
    }

    static class BinaryTreeWithTwoFactors {
        public static int numFactoredBinaryTrees(int[] arr) {
            Arrays.sort(arr);
            Map<Integer, Long> factorMap = new HashMap<>();
            long count = 1;

            for (int i = 0; i < arr.length; i++)
            {
                count = 1;
                if (factorMap.keySet() != null)
                {
                    for (Integer num : factorMap.keySet()) {
                        int reminder = arr [i] % num;
                        int quotient = arr [i] / num;

                        if (reminder == 0 && factorMap.containsKey(quotient)) {
                            count += factorMap.get(num) * factorMap.get(quotient);
                        }
                    }
                }

                factorMap.put(arr [i], count);
            }

            long sum = 0l;
            for (Integer num : factorMap.keySet())
            {
                sum += factorMap.get(num);
            }

            return (int)(sum% ((int)Math.pow(10,9) + 7));
        }
    }
}
