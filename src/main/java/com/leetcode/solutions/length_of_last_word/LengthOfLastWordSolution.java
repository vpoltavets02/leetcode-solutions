package com.leetcode.solutions.length_of_last_word;

/*
https://leetcode.com/problems/length-of-last-word/description/

58. Length of Last Word

Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.

Constraints:

1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.

Personal best:
Runtime: 0 ms, Beats 100.00%
Memory: 43.09 MB, Beats 60.26%
 */

public class LengthOfLastWordSolution {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }

    //    Algorithmic solution:
//    Runtime: 0 ms, Beats 100.00%
//    Memory: 43.09 MB, Beats 60.26%
    public static int lengthOfLastWord(String s) {
        s = s.strip();
        int i = s.length() - 1;
        while (i != 0 && s.charAt(i) != ' ') {
            i--;
        }
        return s.length() - i - 1;
    }

//      Java methods' solution:
//      Runtime: 0 ms, Beats 100.00%
//      Memory: 43.06 MB, Beats 60.26%
//    public static int lengthOfLastWord(String s) {
//        s = s.strip();
//        if (!s.contains(" "))
//            return s.length();
//        s = s.substring(s.lastIndexOf(" "));
//        return s.strip().length();
//    }
}
