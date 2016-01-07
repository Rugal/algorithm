package ga.rugal.dp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class MainTest
{

    private Main instance = new Main();

    public MainTest()
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

    /**
     * Test of longestIncreaseSequence method, of class Main.
     */
    @Test
    @Ignore
    public void testLongestIncreaseSequence()
    {
        System.out.println("Longest Increase Sequence");
        int[] data = new int[]
        {
            1, 0, 2, 3, 0, 6, 8, 1
        };
        int expResult = 5;
        int result = instance.longestIncreaseSequence(data);
        Assert.assertEquals(expResult, result);
    }

    @Test
    @Ignore
    public void testLongestCommonSubsequence()
    {
        System.out.println("Longest Common Subsequence");
        String first = "abcdefgho";
        String second = "anmcldpgo";
        int expResult = 5;
        int result = instance.longestCommonSubsequence(first.toCharArray(), second.toCharArray());
        Assert.assertEquals(expResult, result);
    }

    @Test
    @Ignore
    public void testEditDistance()
    {
        System.out.println("Edit Distance");
        String first = "abcdefg";
        String second = "abcdeg";
        int expResult = 1;
        int result = instance.editDist(first.toCharArray(), second.toCharArray());
        Assert.assertEquals(expResult, result);
    }

    @Test
    @Ignore
    public void testMinCostPath()
    {
        System.out.println("Min Cost Path");
        int[][] cost = new int[][]
        {
            {
                1, 0, 0
            },
            {
                6, 3, 0
            },
            {
                3, 3, 3
            }
        };
        int expResult = 4;
        int result = instance.minCostPath(cost);
        Assert.assertEquals(expResult, result);
    }

    @Test
    @Ignore
    public void testMinCoins()
    {
        System.out.println("minimum number of coins");
        int[] coin = new int[]
        {
            1, 4
        };
        int expResult = 1;
        int result = instance.minCoins(coin, 4);
        Assert.assertEquals(expResult, result);
    }

    @Test
    public void testCountCoins()
    {
        System.out.println("Coin Change");
        int[] coin = new int[]
        {
            1, 2, 3
        };
        int expResult = 4;
        int result = instance.count(coin, 4);
        Assert.assertEquals(expResult, result);
    }
}
