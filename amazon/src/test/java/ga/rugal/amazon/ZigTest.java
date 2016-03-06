package ga.rugal.amazon;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class ZigTest
{

    private final Integer[] data = new Integer[]
    {
        2, 1
    };

    private final Zig instance = new Zig();

    public ZigTest()
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
    public void testFindMax()
    {
        System.out.println("findMax");
        Integer expResult = data[0];
        Integer result = instance.findMax(data);
        Assert.assertEquals(expResult, result);
    }

}
