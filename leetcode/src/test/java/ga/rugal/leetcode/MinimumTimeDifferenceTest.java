package ga.rugal.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author rugal
 */
public class MinimumTimeDifferenceTest {

    private MinimumTimeDifference diff = new MinimumTimeDifference();

    private final List<String> list = new ArrayList<>();

    public MinimumTimeDifferenceTest() {
    }

    @Before
    public void setUp() {
        list.addAll(Arrays.asList(new String[]{"23:59", "00:00", "23:23", "05:00", "13:39", "09:23"}));
    }

    @Test
    public void testFindMinDifference() {
        System.out.println(this.diff.findMinDifference(this.list));
    }
}
