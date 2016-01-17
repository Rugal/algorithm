package ga.rugal.leetcode;

/**
 *
 * @author Rugal Bernstein
 */
public class OddEvenLinkedList
{

    public ListNode oddEvenList(ListNode head)
    {
        if (null == head || null == head.next || null == head.next.next)
        {
            return head;
        }
        ListNode even_head = head.next;
        ListNode odd = head, even = even_head;
        while (even != null && even.next != null)
        {
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = even_head;
        return head;
    }
}

class ListNode
{

    int val;

    ListNode next;

    ListNode(int x)
    {
        val = x;
    }
}
