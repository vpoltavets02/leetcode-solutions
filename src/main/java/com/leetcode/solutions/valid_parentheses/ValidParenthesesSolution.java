package com.leetcode.solutions.valid_parentheses;

/*
https://leetcode.com/problems/valid-parentheses/

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false



Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

Personal best:
Runtime: 3 ms, Beats 87.62%
Memory: 42.84 MB, Beats 96.67%
 */

import java.util.Map;

public class ValidParenthesesSolution {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("(("));
    }

    public static boolean isValid(String s) {
        Stack stack = new Stack(s.length());
        Map<Character, Character> reversedParentheses = Map.of(')', '(', '}', '{', ']', '[');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (reversedParentheses.containsValue(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.peek() != reversedParentheses.get(c)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    static class Stack {

        private char[] stack;
        private int currentIndex = 0;

        public Stack(int capacity) {
            stack = new char[capacity];
        }

        public void push(char ch) {
            stack[currentIndex++] = ch;
        }

        public void pop() {
            --currentIndex;
        }

        public char peek() {
            return stack[currentIndex - 1];
        }

        public boolean isEmpty() {
            return currentIndex == 0;
        }
    }
}
