package ga.rugal.hacker;

/**
 *
 * @author Rugal Bernstein
 */
public class PalindromeList
{

    /**
     *
     * @param head
     *
     * @return
     */
    boolean isPalindrome(Node head)
    {
        if (null == head)
        {
            return false;
        }
        if (null == head.right)
        {
            return true;
        }
        //to get the middle of this list
        Node slow, fast;
        slow = fast = head;
        while (null != fast && null != fast.right)
        {
            slow = slow.right;
            fast = fast.right.right;
        }
        //now slow is the middlo of this list
        //going to rip the other part off
        Node rightHead = reverseList(slow.right);
        boolean value = true;
        for (Node a = head, b = rightHead; b != null; a = a.right, b = b.right)
        {
            if (a.data != b.data)
            {
                value = false;
                break;
            }
        }
        slow.right = reverseList(rightHead);
        return value;
    }

    Node reverseList(Node node)
    {
        if (null == node)
        {
            return null;
        }
        final Node originHead = node;
        Node before = node;
        node = node.right;
        while (node != null)
        {
            Node current = node;
            node = node.right;
            current.right = before;
            before = current;
        }
        originHead.right = null;
        return before;
    }
}
