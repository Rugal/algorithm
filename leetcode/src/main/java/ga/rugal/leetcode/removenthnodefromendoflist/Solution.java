package ga.rugal.leetcode.removenthnodefromendoflist;

import ga.rugal.leetcode.ListNode;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public ListNode removeNthFromEnd(ListNode head, final int n) {
    ListNode current = head, last = head;
    for (int i = 0; i < n; ++i) {
      last = last.next;
    }
    while (last != null && null != last.next) {
      last = last.next;
      current = current.next;
    }
    if (head == current && last == null) {
      head = head.next;
    } else {
      current.next = current.next.next;
    }
    return head;
  }
}
