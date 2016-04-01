package ga.rugal.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class RBTreeTest
{

    private final RBTree<Integer, Integer> instance = new RBTree<>();

    public RBTreeTest()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testPut()
    {
        System.out.println("put");
        instance.put(1, 1);
        instance.put(2, 1);
        instance.put(3, 1);
        instance.put(4, 1);
        instance.put(5, 1);
    }

}
