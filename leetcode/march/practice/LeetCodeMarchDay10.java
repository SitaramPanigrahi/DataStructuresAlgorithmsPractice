package leetcode.march.practice;

/*
Integer to Roman : https://leetcode.com/explore/featured/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3667/
 */
public class LeetCodeMarchDay10 {
    public static void main(String[] args) {
        System.out.println("Test 1 : 1000 to Roman = " + IntegerToRoman.intToRoman(1000));
        System.out.println("Test 2 : 9 to Roman = " + IntegerToRoman.intToRoman(9));
        System.out.println("Test 3 : 58 to Roman = " + IntegerToRoman.intToRoman(58));
        System.out.println("Test 4 : 40 to Roman = " + IntegerToRoman.intToRoman(40));
        System.out.println("Test 6 : 190 to Roman = " + IntegerToRoman.intToRoman(190));
        System.out.println("Test 7 : 499 to Roman = " + IntegerToRoman.intToRoman(499));
        System.out.println("Test 8 : 700 to Roman = " + IntegerToRoman.intToRoman(700));

    }

    static class IntegerToRoman {
        public static String intToRoman(int num) {
            StringBuilder ans = new StringBuilder();

            while (num > 0) {
                if (num == 1)
                {
                    num = num - 1;
                    ans.append("I");
                }
                else if (num == 2)
                {
                    num = num - 2;
                    ans.append("II");
                }
                else if (num == 3)
                {
                    num = num - 3;
                    ans.append("III");
                }
                else if (num == 4)
                {
                    num = num - 4;
                    ans.append("IV");
                }
                else if (num == 5)
                {
                    num = num - 5;
                    ans.append("V");
                }
                else if (num == 6)
                {
                    num = num - 6;
                    ans.append("VI");
                }
                else if (num == 7)
                {
                    num = num - 7;
                    ans.append("VII");
                }
                else if (num == 8)
                {
                    num = num - 8;
                    ans.append("VIII");
                }
                else if (num == 9)
                {
                    num = num - 9;
                    ans.append("IX");
                }
                else if (num == 10)
                {
                    num = num - 10;
                    ans.append("X");
                }
                else if (num >= 1000)
                {
                    num = num - 1000;
                    ans.append("M");
                }
                else if (num >= 900) {
                    num = num - 900;
                    ans.append("CM");
                }
                else if (num >= 500)
                {
                    num = num - 500;
                    ans.append("D");
                }
                else if (num >= 400) {
                    num = num - 400;
                    ans.append("CD");
                }
                else if (num >= 100)
                {
                    num = num - 100;
                    ans.append("C");
                }
                else if (num >= 90) {
                    num = num - 90;
                    ans.append("XC");
                }
                else if (num >= 50) {
                    num = num - 50;
                    ans.append("L");
                }
                else if (num >= 40) {
                    num = num - 40;
                    ans.append("XL");
                }
                else if (num > 10)
                {
                    num = num - 10;
                    ans.append("X");
                }
            }

            return ans.toString();
        }
    }
}
