package ga.rugal.leetcode;

/**
 *
 * @author Rugal Bernstein
 */
public class DecodeWays
{

    /**
     * Several cases to discuss <BR>
     * Previous one is 0:<BR>
     * The new one must in 1-9, so the number of combination not change<BR>
     * Previous one is not 0:<BR>
     * 1. New one is 0: <BR>
     * there is no other combination except 10 and 20 because 0 could not stand alone, not change
     * <BR>
     * 2. not 0: <BR>
     * 2.1. valid number:<BR>
     * Such like 14 19. In this case number of combination will increase by 1<BR>
     * 2.2. invalid:<BR>
     * Such as 34 91. In this case, not change
     *
     * @param s
     *
     * @return
     */
    public int numDecodings(String s)
    {
        if (null == s || s.isEmpty() || s.startsWith("0") || s.contains("00"))
        {
            return 0;
        }
        if (s.length() == 1 && s.charAt(0) >= '1' && s.charAt(0) >= '9')
        {
            return 1;
        }
        int[] total = new int[s.length() + 1];
        total[0] = total[1] = 1;

        for (int i = 2; i <= s.length(); i++)
        {
            int digit = s.charAt(i - 1) - '0';
            int ten = s.charAt(i - 2) - '0';
            if (0 == digit) // current number is 0
            {
                if (ten > 2)
                {
                    return 0;
                }
                //it has to combine with previous number
                total[i] = total[i - 2];
            } else
            {
                int combine = 10 * ten + digit;

                if (combine >= 10 && combine <= 26)
                {
                    total[i] = total[i - 1] + total[i - 2];
                } else
                {
                    //if previous number is 0
                    //it has to stay alone
                    total[i] = total[i - 1];
                }
            }
        }
        return total[s.length()];
    }
}
