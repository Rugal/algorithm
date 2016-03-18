package ga.rugal.leetcode;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class DecodeWaysTest
{

    private final DecodeWays instance = new DecodeWays();

    public DecodeWaysTest()
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
    public void testNumDecodings()
    {
        System.out.println("numDecodings");
        String s = "11";
        int expResult = 2;
        int result = instance.numDecodings(s);
        Assert.assertEquals(expResult, result);
    }

}
