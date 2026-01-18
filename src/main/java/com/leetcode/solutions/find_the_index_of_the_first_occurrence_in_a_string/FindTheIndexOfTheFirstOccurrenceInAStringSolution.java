package com.leetcode.solutions.find_the_index_of_the_first_occurrence_in_a_string;

/*
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

28. Find the Index of the First Occurrence in a String

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.

Personal best:
Runtime: 0 ms, Beats 100.00%
Memory: 42.80 MB, Beats 80.22%
 */

public class FindTheIndexOfTheFirstOccurrenceInAStringSolution {

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("a", "a"));
    }

//   Java methods' solution:
//   Runtime: 0 ms, Beats: 100.00%
//   Memory: 42.80 MB, Beats: 80.22%
    public static int strStr(String haystack, String needle) {
        if (!haystack.contains(needle))
            return -1;
        return haystack.indexOf(needle);
    }
//    Algorithmic solution:
//    Runtime: 0 ms, Beats: 100.00%
//    Memory: 43.04 MB, Beats: 53.52%
//    public static int strStr(String haystack, String needle) {
//        if (!haystack.contains(needle))
//            return -1;
//        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
//            if (haystack.charAt(i) == needle.charAt(0) &&
//                    haystack.startsWith(needle, i))
//                return i;
//        }
//        return -1;
//    }
}
