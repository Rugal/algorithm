package ga.rugal.hacker;

import ga.rugal.hacker.DivideNumber;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class DivideNumberTest
{

    private final DivideNumber instance = new DivideNumber();

    public DivideNumberTest()
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
    public void testDivide()
    {
        System.out.println("divide");
        int total = 100;
        int divisor = 3;
        String expResult = "33.(3)";
        String result = instance.divide(total, divisor);
        Assert.assertEquals(expResult, result);
        total = 1;
        divisor = 4;
        expResult = "0.25";
        result = instance.divide(total, divisor);
        Assert.assertEquals(expResult, result);
        total = 9;
        divisor = 7;
        expResult = "1.(285714)";
        result = instance.divide(total, divisor);
        Assert.assertEquals(expResult, result);
    }

}
