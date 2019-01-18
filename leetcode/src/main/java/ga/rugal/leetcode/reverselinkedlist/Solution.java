package ga.rugal.leetcode.reverselinkedlist;

import ga.rugal.leetcode.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
public class Solution {

  public ListNode reverseList(ListNode head) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode last = head;
    ListNode current = last.next;
    head.next = null;
    while (null != current) {
      ListNode temp = current.next;
      current.next = last;
      last = current;
      current = temp;
    }
    return last;
  }
}
