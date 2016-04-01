package ga.rugal.tree;

/**
 *
 * @author Rugal Bernstein
 */
public class SpiralMatrix
{

    public void spiral(int[][] matrix)
    {
        int left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
        int elements = matrix[0].length * matrix.length;
        for (int count = 0; count < elements;)
        {
            //up
            for (int i = left; i <= right; i++)
            {
                System.out.print(matrix[up][i] + " ");
                count++;
            }
            up++;
            if (count >= elements)
            {
                break;
            }
            //right
            for (int i = up; i <= down; i++)
            {
                System.out.print(matrix[i][right] + " ");
                count++;
            }
            right--;
            //down
            for (int i = right; i >= left; i--)
            {
                System.out.print(matrix[down][i] + " ");
                count++;
            }
            down--;
            //left
            for (int i = down; i >= up; i--)
            {
                System.out.print(matrix[i][left] + " ");
                count++;
            }
            left++;
        }
    }
}
