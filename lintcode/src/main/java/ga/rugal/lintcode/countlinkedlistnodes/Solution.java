package ga.rugal.lintcode.countlinkedlistnodes;

import ga.rugal.lintcode.ListNode;

/**
 *
 * @author Rugal Bernstein
 */
public class Solution {

  /**
   * @param head: the first node of linked list.
   *
   * @return: An integer
   */
  public int countNodes(final ListNode head) {
    // write your code here
    int count = 0;
    for (ListNode current = head; current != null; count++, current = current.next);
    return count;
  }
}
