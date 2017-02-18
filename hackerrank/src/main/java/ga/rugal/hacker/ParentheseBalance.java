package ga.rugal.hacker;

import java.util.Stack;

/**
 * 2. Given a string of parentheses, find if the expression is balanced or not ?
 *
 * @author Rugal Bernstein
 */
public class ParentheseBalance
{

    public boolean ifBalanced(String input)
    {
        if (null == input || input.isEmpty())
        {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        int index = 1;
        stack.push(input.charAt(0));
        while (!stack.isEmpty() && index < input.length())
        {
            char c = input.charAt(index);
            if ('(' == c)
            {
                stack.push(c);
            } else
            {
                if (stack.peek() == '(')
                {
                    stack.pop();
                } else
                {
                    return false;
                }
            }
            index++;
        }
        return stack.isEmpty();
    }
}
