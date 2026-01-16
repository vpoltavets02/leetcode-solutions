package com.leetcode.solutions.merge_two_sorted_lists;

/*
https://leetcode.com/problems/merge-two-sorted-lists/

21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.

Personal best:
Runtime: 0 ms, Beats 100.00%%
Memory: 44.50 MB, Beats 11.81%
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeTwoSortedListsSolution {

    public static void main(String[] args) {
        ListNode temp = new ListNode(2);
        ListNode head1 = new ListNode(1, temp);
        temp.next = new ListNode(4);
        temp = new ListNode(3);
        ListNode head2 = new ListNode(1, temp);
        temp.next = new ListNode(4);
        ListNode result = mergeTwoLists(head1, head2);
        while (result != null) {
            result = result.next;
            System.out.println(result.val);
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
            return null;
        ListNode value;
        ListNode head = new ListNode();
        ListNode current = new ListNode();
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                value = new ListNode(list2.val);
                list2 = list2.next;
            } else if (list2 == null) {
                value = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                if (list1.val <= list2.val) {
                    value = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    value = new ListNode(list2.val);
                    list2 = list2.next;
                }
            }
            if (head.val == 0) {
                head = new ListNode(value.val);
                current = head;
            } else {
                current.next = new ListNode(value.val);
                current = current.next;
            }
        }
        return head;
    }
}

// niits's solution
//
//public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//    ListNode dummy = new ListNode();
//    ListNode cur = dummy;
//
//    while (list1 != null && list2 != null) {
//        if (list1.val > list2.val) {
//            cur.next = list2;
//            list2 = list2.next;
//        } else {
//            cur.next = list1;
//            list1 = list1.next;
//        }
//        cur = cur.next;
//    }
//
//    cur.next = (list1 != null) ? list1 : list2;
//
//    return dummy.next;
//}
