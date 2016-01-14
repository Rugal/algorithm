package ga.rugal.leetcode;

import java.util.Stack;

/**
 *
 * @author Administrator
 */
public class RemoveDuplicateLetters
{

    public String removeDuplicateLetters(String s)
    {
        if (null == s || s.isEmpty())
        {
            return "";
        }
        Stack<Character> result = new Stack<>();
        int[] times = new int[26];
        //record the occurance time of each character
        for (int i = 0; i < s.length(); i++)
        {
            //convert char type into int type by ASIIC
            times[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++)
        {
            int index = s.charAt(i) - 'a';

            //reduce occurance time
            times[index]--;
            //add unless never seem before
            if (result.search(s.charAt(i)) != -1)
            {
                continue;
            }
            //To achieve smallest alphabetic order
            //if the element we get now is smaller than the current last character
            //and also same characters  repeated after
            while (!result.isEmpty() && s.charAt(i) < result.peek() && times[result.peek() - 'a'] != 0)
            {
                //we remove the current last character because this will reduce alphabetic order sum
                result.pop();
            }
            result.push(s.charAt(i));
        }
        //output the result from stack
        StringBuilder sb = new StringBuilder();

        int size = result.size();
        char[] resultStr = new char[size];
        while (size > 0)
        {
            resultStr[size - 1] = result.pop();
            size--;
        }
        return String.valueOf(resultStr);
    }
}
