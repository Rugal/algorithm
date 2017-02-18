package ga.rugal.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rugal Bernstein
 */
public class ValidAnagram
{

    public boolean isAnagram(String s, String t)
    {
        if (s.length() != t.length())
        {
            return false;
        }
        Map<Character, Integer> compare = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++)
        {
            Integer value = compare.getOrDefault(s.charAt(i), 0);
            compare.put(s.charAt(i), value + 1);
        }
        for (int i = 0; i < t.length(); i++)
        {
            Integer value = compare.get(t.charAt(i));
            if (null == value)
            {
                return false;
            }
            if (value == 1)
            {
                compare.remove(t.charAt(i));
            } else
            {
                compare.put(t.charAt(i), value - 1);
            }
        }
        return compare.isEmpty();
    }
}
