package ga.rugal.leetcode;

/**
 *
 * @author Rugal Bernstein
 */
public class MoveZeroes
{

    public void moveZeroes(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            int digit;
            for (digit = i; digit < nums.length; digit++)
            {
                if (0 != nums[digit])
                {
                    break;
                }
            }
            if (digit >= nums.length)
            {
                break;
            }
            int zero;
            for (zero = i; zero < nums.length; zero++)
            {
                if (0 == nums[zero])
                {
                    break;
                }
            }
            if (zero >= nums.length || 0 != nums[zero])
            {
                break;
            }
            if (digit < zero)
            {
                continue;
            }
            int temp = nums[digit];
            nums[digit] = nums[zero];
            nums[zero] = temp;
        }
    }

    public static void main(String[] args)
    {
        MoveZeroes mz = new MoveZeroes();
        int[] data = new int[]
        {
            1, 0
        };
        mz.moveZeroes(data);
        for (int d : data)
        {
            System.out.println(d);
        }
    }
}
