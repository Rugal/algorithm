package ga.rugal.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
@Slf4j
public class DecodeWaysTest {

    private final DecodeWays instance = new DecodeWays();

    public DecodeWaysTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    @Ignore
    public void testNumDecodings() {
        System.out.println("numDecodings");
        String s = "11";
        int expResult = 2;
        int result = instance.numDecodings(s);
        Assert.assertEquals(expResult, result);
    }

    @Test
    public void test() {
        Integer a = 1, b = 1;
        Integer c = 200, d = 200;
        LOG.info("TEST");
        Assert.assertEquals(a, b);
        Assert.assertEquals(c, d);
    }
}
