package ga.rugal.hacker;

import java.util.LinkedList;

/**
 * http://www.geeksforgeeks.org/google-mountain-view-interview/ <BR>
 * 2) Divide number and return result in form of a string. e.g 100/3 result should be 33.(3) Here 3
 * is in brackets because it gets repeated continuously and 5/10 should be 0.5.
 *
 *
 * @author Rugal Bernstein
 */
public class DivideNumber
{

    public String divide(int total, int divisor)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(total / divisor);
        LinkedList<Integer> list = new LinkedList<>();
        int startRemain = total % divisor;
        if (startRemain != 0)
        {
            int lastRemain = startRemain;
            do
            {
                list.add(lastRemain * 10 / divisor);
                lastRemain = lastRemain * 10 % divisor;
            } while (lastRemain != 0 && lastRemain * 10 / divisor != list.getFirst());
            int decimal = 0;
            for (int i = 0; i < list.size(); i++)
            {
                decimal *= 10;
                decimal += list.get(i);
            }
            sb.append(".");
            if (lastRemain != 0)
            {
                sb.append("(");
            }
            sb.append(decimal);
            if (lastRemain != 0)
            {
                sb.append(")");
            }
        }
        return sb.toString();
    }
}
