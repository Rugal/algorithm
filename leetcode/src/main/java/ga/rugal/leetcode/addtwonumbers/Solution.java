package ga.rugal.leetcode.addtwonumbers;

import ga.rugal.leetcode.ListNode;

/**
 * Add two numbers.<BR>
 * https://leetcode.com/problems/add-two-numbers/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public ListNode addTwoNumbers(ListNode input1, ListNode input2) {
    final ListNode head = new ListNode(0);
    ListNode current = head;
    int carry = 0;
    while (input1 != null || input2 != null) {
      final int a = input1 != null ? input1.val : 0;
      final int b = input2 != null ? input2.val : 0;
      carry += (a + b);
      current.next = new ListNode(carry % 10);
      carry /= 10;
      current = current.next;
      input1 = input1 == null ? null : input1.next;
      input2 = input2 == null ? null : input2.next;
    }

    if (carry > 0) {
      current.next = new ListNode(carry);
    }

    return head.next;
  }
}
