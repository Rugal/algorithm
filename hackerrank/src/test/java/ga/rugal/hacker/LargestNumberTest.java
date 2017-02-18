package ga.rugal.hacker;

import ga.rugal.hacker.LargestNumber;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class LargestNumberTest
{

    private final LargestNumber instance = new LargestNumber();

    public LargestNumberTest()
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
    public void testGet()
    {
        System.out.println("get");
        int[] input = new int[]
        {
            6, 5, 4, 3, 2, 1, 0
        };
        int[] expResult = new int[]
        {
            5, 4, 3, 2, 1, 0, -1
        };
        int[] result = instance.get(input);
        Assert.assertArrayEquals(expResult, result);
    }

}
