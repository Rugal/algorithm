package ga.rugal.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rugal Bernstein
 */
public class AVLTreeTest
{

    private AVLTree<Integer, String> tree;

    public AVLTreeTest()
    {
    }

    @Before
    public void setUp()
    {
        tree = new AVLTree<>();
        tree.put(0, "rugal");
    }

    @After
    public void tearDown()
    {
        System.out.println(tree);
    }

    /**
     * Test of AVL tree for left rotation with right right case.
     */
    @Test
    public void testRRCase()
    {
        System.out.println("left rotation");
        tree.put(1, "bernstein");
        tree.put(2, "tenjin");
    }

    /**
     * Test of AVL tree for right rotation with left left case.
     */
    @Test
    public void testLLCase()
    {
        System.out.println("right rotation");
        tree.put(-1, "bernstein");
        tree.put(-2, "rugal");
    }

    /**
     * Test of AVL tree for left rotation with right left case.
     */
    @Test
    public void testRLCase()
    {
        System.out.println("right -> left rotation");
        tree.put(3, "bernstein");
        tree.put(1, "tenjin");

    }

    /**
     * Test of AVL tree for right rotation with left right case.
     */
    @Test
    public void testLRCase()
    {
        System.out.println("left -> right rotation");
        tree.put(-2, "bernstein");
        tree.put(-1, "tenjin");
    }

    @Test
    public void testRemoveRoot()
    {
        System.out.println("remove root");
        tree.put(1, "bernstein");
        tree.put(2, "tenjin");
        tree.remove(0);
    }

    @Test
    public void testRemoveMiddle()
    {
        System.out.println("remove middle");
        tree.put(1, "bernstein");
        tree.put(2, "tenjin");
        tree.remove(1);
    }

    @Test
    public void testRemoveLeaf()
    {
        System.out.println("remove leaf");
        tree.put(1, "bernstein");
        tree.put(2, "tenjin");
        tree.remove(2);
    }
}
