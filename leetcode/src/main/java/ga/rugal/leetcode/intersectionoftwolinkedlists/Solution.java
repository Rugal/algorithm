package ga.rugal.leetcode.intersectionoftwolinkedlists;

import ga.rugal.leetcode.ListNode;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public ListNode getIntersectionNode(final ListNode headA, final ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    //add dummy head
    final ListNode beforeA = new ListNode(0);
    beforeA.next = headA;
    final ListNode beforeB = new ListNode(0);
    beforeB.next = headB;

    ListNode a = headA;
    ListNode b = headB;
    final boolean[] set = new boolean[2];//see if reaches the end
    while (a != b) {
      if (a.next == null && !set[0]) {
        a = beforeB;
        set[0] = true;
      }
      if (b.next == null && !set[1]) {
        b = beforeA;
        set[1] = true;
      }
      a = a.next;
      b = b.next;
    }
    return a == b ? a : null;
  }
}
