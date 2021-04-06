package ga.rugal.reuters.constructionmanagement;

import java.util.List;

public class Result {

  /*
   * Complete the 'minCost' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY cost as parameter.
   */
  public static int minCost(final List<List<Integer>> cost) {
    final int ROW = cost.size();
    final int COLUMN = cost.get(0).size();
    final int[] table = new int[COLUMN];
    for (int i = 0; i < COLUMN; ++i) {
      table[i] = cost.get(0).get(i);
    }
    for (int i = 1; i < ROW; ++i) {
//      final int[] l = left(cost.get(i));
//      final int[] r = right(cost.get(i));
      for (int j = 0; j < COLUMN; ++j) {
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < COLUMN; ++k) {
          if (k != j) {
            min = Math.min(min, cost.get(i).get(k));
          }
        }
//        if (j > 0) {
//          // minimum from left side
//          localMin = Math.min(localMin, l[j - 1]);
//        }
//        if (j < COLUMN - 1) {
//          // minimum from right side
//          localMin = Math.min(localMin, r[j + 1]);
//        }
        table[j] += min;
      }
    }

    int result = Integer.MAX_VALUE;
    for (int n : table) {
      result = Math.min(result, n);
    }
    return result;
  }

  private static int[] left(final List<Integer> cost) {
    final int[] data = new int[cost.size()];
    data[0] = cost.get(0);
    for (int i = 1; i < cost.size(); ++i) {
      data[i] = Math.min(data[i - 1], cost.get(i));
    }
    return data;
  }

  private static int[] right(final List<Integer> cost) {
    final int[] data = new int[cost.size()];
    data[cost.size() - 1] = cost.get(cost.size() - 1);
    for (int i = cost.size() - 2; i >= 0; --i) {
      data[i] = Math.min(data[i + 1], cost.get(i));
    }
    return data;
  }
}
