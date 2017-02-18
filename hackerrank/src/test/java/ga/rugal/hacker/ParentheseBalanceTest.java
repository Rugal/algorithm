package ga.rugal.hacker;

import ga.rugal.hacker.ParentheseBalance;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class ParentheseBalanceTest
{

    private final ParentheseBalance instance = new ParentheseBalance();

    private final String[] data = new String[]
    {
        "((()))", "(((()", "()()(())", "(((("
    };

    private final boolean[] results = new boolean[]
    {
        true, false, true, false
    };

    public ParentheseBalanceTest()
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
    public void testIfBalanced()
    {
        System.out.println("ifBalanced");
        for (int i = 0; i < data.length; i++)
        {
            boolean result = instance.ifBalanced(data[i]);
            Assert.assertEquals(results[i], result);
        }
    }
}
