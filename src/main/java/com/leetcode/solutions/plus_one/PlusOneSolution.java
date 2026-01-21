package com.leetcode.solutions.plus_one;

import java.util.Arrays;

/*
https://leetcode.com/problems/plus-one/

66. Plus One

You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
The digits are ordered from most significant to least significant in left-to-right order.
The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.

Personal best:
Runtime: 0 ms, Beats 100.00%
Memory: 43.25 MB, Beats 84.93%
*/

public class PlusOneSolution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
    }

    // my solution (Runtime: 0 ms, Beats 100.00%, Memory: 43.25 MB, Beats 84.93%)
    public static int[] plusOne(int[] digits) {
        int lastIndex = digits.length - 1;
        if (digits[lastIndex] != 9) {
            digits[lastIndex] = digits[lastIndex] + 1;
            return digits;
        }

        boolean needAdd = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (needAdd) {
                digits[i]++;
            }
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                needAdd = false;
            }
        }

        if (digits[0] == 0) {
            int[] temp = new int[digits.length + 1];
            temp[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                temp[i + 1] = digits[i];
            }

            digits = temp;
        }

        return digits;
    }

    // refactored code after looking at other solutions (the best results didn't change)
//    public static int[] plusOne(int[] digits) {
//        for (int i = digits.length - 1; i >= 0; i--) {
//            digits[i] += 1;
//            if (digits[i] == 10) {
//                digits[i] = 0;
//            } else {
//                return digits;
//            }
//        }
//
//        int[] temp = new int[digits.length + 1];
//        temp[0] = 1;
//        return temp;
//    }
}
