package ga.rugal.amazon;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class PalindromeListTest
{

    private PalindromeList list = new PalindromeList();

    private Node head;

    public PalindromeListTest()
    {
    }

    @Before
    public void setUp()
    {
        head = new Node(0);
        head.right = new Node(1);
        head.right.right = new Node(2);
        head.right.right.right = new Node(3);
        head.right.right.right.right = new Node(3);
        head.right.right.right.right.right = new Node(2);
        head.right.right.right.right.right.right = new Node(1);
        head.right.right.right.right.right.right.right = new Node(0);

    }

    @After
    public void tearDown()
    {
        for (Node it = head; it != null; it = it.right)
        {
            System.out.println(it.data);
        }
    }

//    @Test
    public void testSomeMethod()
    {
        head = list.reverseList(head);
        head = list.reverseList(head);
    }

    @Test
    public void testIsPalindrome()
    {
        Assert.assertTrue(list.isPalindrome(head));

    }

}
