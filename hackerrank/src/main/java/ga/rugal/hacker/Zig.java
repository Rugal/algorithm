package ga.rugal.hacker;

/**
 * 1. Given an array of elements which is first increasing and then decreasing, find the maximum
 * element in the array. Points where based on how we handle the corner cases like what if we have
 * only two elements in the array.
 *
 * @author Rugal Bernstein
 */
public class Zig
{

    public Integer findMax(Integer[] array)
    {
        if (null == array || array.length == 0)
        {
            return null;
        }
        if (2 >= array.length)
        {
            if (1 == array.length)
            {
                return array[0];
            }
            return array[0] > array[1] ? array[0] : array[1];
        }

        Integer max = array[0];
        for (Integer a : array)
        {
            if (max > a)
            {
                break;
            }
            max = a;
        }
        return max;
    }
}
