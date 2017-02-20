package ga.rugal.leetcode;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author rugal
 */
public class CoinChange2Test {

    private final CoinChange2 instance = new CoinChange2();

    public CoinChange2Test() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testChange() {
        System.out.println("change");
        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        int expResult = 4;
        int result = instance.change(amount, coins);
        Assert.assertEquals(expResult, result);
    }
}
