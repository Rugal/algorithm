package ga.rugal.leetcode.mergeksortedlists;

import ga.rugal.leetcode.ListNode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * @author Rugal Bernstein
 */
public class Solution {

  public ListNode mergeKLists(final ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    ListNode head = lists[0];
    for (int i = 1; i < lists.length; ++i) {
      head = this.mergeList(head, lists[i]);
    }
    return head;
  }

  public ListNode mergeList(ListNode list1, ListNode list2) {
    if (list1 == null && list2 == null) {
      return null;
    }
    if (list1 == null || list2 == null) {
      return list1 == null ? list2 : list1;
    }

    ListNode current;
    if (list1.val < list2.val) {
      current = list1;
      list1 = list1.next;
    } else {
      current = list2;
      list2 = list2.next;
    }
    ListNode head = current;
    for (; list1 != null && list2 != null; current = current.next) {
      if (list1.val < list2.val) {
        current.next = list1;
        list1 = list1.next;
      } else {
        current.next = list2;
        list2 = list2.next;
      }
    }

    if (list1 == null || list2 == null) {
      current.next = list1 == null ? list2 : list1;
    }

    return head;
  }
}
