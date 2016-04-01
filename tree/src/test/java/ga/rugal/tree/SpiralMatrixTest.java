package ga.rugal.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class SpiralMatrixTest
{

    private final SpiralMatrix instance = new SpiralMatrix();

    private final int[][] matrix = new int[][]
    {
        {
            1, 2, 3, 4
        },
        {
            5, 6, 7, 8
        },
        {
            9, 10, 11, 12
        },
        {
            13, 14, 15, 16
        }
    };

    public SpiralMatrixTest()
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
    public void testSpiral()
    {
        System.out.println("spiral");
        instance.spiral(matrix);
    }

}
