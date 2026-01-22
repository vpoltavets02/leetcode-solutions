package com.leetcode.solutions.add_binary;

/*
https://leetcode.com/problems/add-binary

67. Add Binary

Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.

Personal best:
Runtime: 3 ms, Beats 18.15%
Memory: 44.56 MB, Beats 9.90%
 */

public class AddBinarySolution {

    public static void main(String[] args) {
        System.out.println(new AddBinarySolution().addBinary("1111", "1111"));
        System.out.println(new AddBinarySolution().addBinary("11", "1"));
    }

    // Solution from the net (Runtime: 1 ms, Beats 99.69%, Memory: 43.46 MB, Beats 77.27%)
    public static String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();

        if (n < m) {
            return addBinary(b, a);
        }

        int j = m - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            int bit1 = a.charAt(i) - '0';
            int sum = bit1 + carry;

            if (j >= 0) {
                int bit2 = b.charAt(j) - '0';
                sum += bit2;
                j--;
            }

            int bit = sum % 2;
            carry = sum / 2;

            result.append((char) (bit + '0'));
        }

        if (carry > 0)
            result.append('1');

        return result.reverse().toString();
    }

//    My solution (Runtime: 3 ms, Beats 18.15%, Memory: 44.56 MB, Beats 9.90%)
//    public static String addBinary(String a, String b) {
//        if (a.equals("0") && b.equals("0"))
//            return "0";
//        StringBuilder sb = new StringBuilder();
//        int diff = Math.abs(a.length() - b.length());
//        if (diff != 0) {
//            if (a.length() > b.length()) {
//                b = "0".repeat(diff) + b;
//            } else {
//                a = "0".repeat(diff) + a;
//            }
//        }
//
//        char[] aArray = a.toCharArray();
//        char[] bArray = b.toCharArray();
//
//        boolean carry = false;
//        for (int i = aArray.length - 1; i >= 0; i--) {
//            int c1 = aArray[i];
//            int c2 = bArray[i];
//            if (carry) {
//                if (c1 != c2) {
//                    if (c1 == 48) {
//                        c1 = '1';
//                    } else {
//                        c2 = '1';
//                    }
//                } else {
//                    c1 = c1 == 49 ? '0' : '1';
//                    carry = c1 == 48;
//                }
//            }
//            if (c1 == c2) {
//                sb.append(0);
//                carry = c1 == 49;
//            } else if ((c1 == '0' && c2 == '1') || (c1 == '1' && c2 == '0')) {
//                sb.append(1);
//            }
//        }
//
//        String result = sb.reverse().toString();
//        return result.charAt(0) == '0' || aArray[0] == '1' && bArray[0] == '1' ? "1" + result : result;
//    }
}
