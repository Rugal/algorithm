package ga.rugal.leetcode.mergeksortedlists;

import ga.rugal.leetcode.ListNode;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rugal Bernstein
 */
public class SolutionTest {

  private final Solution solution = new Solution();

  private ListNode list1, list2, list3;

  @Before
  public void setUp() {
    this.list1 = new ListNode(0);
    this.list1.next = new ListNode(5);
    this.list1.next.next = new ListNode(9);

    this.list2 = new ListNode(1);
    this.list2.next = new ListNode(3);
    this.list2.next.next = new ListNode(8);
    this.list2.next.next.next = new ListNode(10);

    this.list3 = new ListNode(4);
    this.list3.next = new ListNode(11);
    this.list3.next.next = new ListNode(13);
    this.list3.next.next.next = new ListNode(15);
    this.list3.next.next.next.next = new ListNode(16);
  }

  private void verify(final ListNode mergeList) {
    for (ListNode temp = mergeList, next = temp.next; next != null; temp = temp.next, next = next.next) {
      Assert.assertThat(temp.val, Matchers.lessThanOrEqualTo(next.val));
    }
  }

  @Test
  public void testMergeKLists() {
    this.verify(this.solution.mergeKLists(new ListNode[]{this.list1, this.list2, this.list3}));
  }

  @Test
  public void testMergeList() {
    this.verify(this.solution.mergeList(list1, list2));
  }
}
