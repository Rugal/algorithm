package ga.rugal.lintcode.amazon.reverselinkedlist;

import ga.rugal.lintcode.ListNode;

/**
 * https://www.lintcode.com/problem/reverse-linked-list
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
