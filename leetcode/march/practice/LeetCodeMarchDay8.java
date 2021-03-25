package leetcode.march.practice;
/*
https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3665/
 */
public class LeetCodeMarchDay8 {
    public static void main(String[] args) {
        System.out.println(RemovePalindromicSubsequences.removePalindromeSub("aabb"));
    }

    static class RemovePalindromicSubsequences {
        public static int removePalindromeSub(String s) {
            if (null == s || s.isEmpty ()) return 0;
            if (s.length () == 1) return 1;
            if (s.length () == 2 && s.charAt (1) == s.charAt (2)) return 1;

            String reverse = new StringBuilder (s).reverse ().toString ();
            if (s.equals (reverse)) return 1;

            else return 2;
        }
    }
}
