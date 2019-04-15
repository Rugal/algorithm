package ga.rugal.leetcode.removenthnodefromendoflist;

import ga.rugal.leetcode.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public ListNode removeNthFromEnd(final ListNode head, final int n) {
    //listen! always add dummy head in these kinds of questions
    final ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;
    // Advances first pointer so that the gap between first and second is n nodes apart
    for (int i = 1; i <= n + 1; i++) {
      first = first.next;
    }
    // Move first to the end, maintaining the gap
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    return dummy.next;
  }
}
