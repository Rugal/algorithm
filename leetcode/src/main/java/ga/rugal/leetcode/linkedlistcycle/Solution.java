package ga.rugal.leetcode.linkedlistcycle;

import ga.rugal.leetcode.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/solution/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public boolean hasCycle(final ListNode head) {
    if (null == head || head.next == null) {
      return false;
    }
    for (ListNode slow = head, fast = head.next;
         fast != null && fast.next != null;
         slow = slow.next, fast = fast.next.next) {
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}
