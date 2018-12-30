package ga.rugal.leetcode.addtwonumbers;

import ga.rugal.leetcode.ListNode;

/**
 * Add two numbers.<BR>
 * https://leetcode.com/problems/add-two-numbers/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  private int getLength(final ListNode list) {
    int i = 0;
    for (ListNode n = list; n != null; n = n.next, ++i);
    return i;
  }

  public ListNode addTwoNumbers(ListNode input1, ListNode input2) {
    final int l1 = this.getLength(input1);
    final int l2 = this.getLength(input2);
    final ListNode list1 = l1 >= l2 ? input1 : input2;
    final ListNode list2 = l1 < l2 ? input1 : input2;

    ListNode current = list1;

    for (ListNode n2 = list2;
         null != n2 && null != current;
         current = current.next, n2 = n2.next) {
      if (null == current.next) {
        current.next = new ListNode(0);
      }
      current.next.val += (current.val + n2.val) / 10;
      current.val = (current.val + n2.val) % 10;
      if (0 == current.next.val && current.next.next == null) {
        current.next = null;
      }
    }
    for (; current != null; current = current.next) {
      if (null == current.next) {
        current.next = new ListNode(0);
      }
      current.next.val += current.val / 10;
      current.val = current.val % 10;
      if (0 == current.next.val && current.next.next == null) {
        current.next = null;
      }
    }
    return list1;
  }
}
