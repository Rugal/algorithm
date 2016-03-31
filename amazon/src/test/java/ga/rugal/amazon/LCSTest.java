package ga.rugal.amazon;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class LCSTest
{

    private final LCS instance = new LCS();

    public LCSTest()
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
    public void testSearch()
    {
        System.out.println("search");
        String a = "aaarbucgddddaelfccc";
        String b = "rugal";
        int expResult = 5;
        int result = instance.search(a, b);
        Assert.assertEquals(expResult, result);
    }

}
