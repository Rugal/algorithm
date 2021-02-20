package ga.rugal.amazon.trappingrainwaterii;

import java.util.PriorityQueue;

public class Solution {

  private class Coordinates {
    int row;
    int col;

    public Coordinates(int r, int c) {
      this.row = r;
      this.col = c;
    }
  }

  //direction to visit
  private static int[][] DIRECTION = new int[][] {
    {0, 0, 1, -1},
    {1, -1, 0, 0}
  };

  public int trapRainWater(int[][] height) {
    // solving using priority queue
    int m = height.length;
    int n = height[0].length;

    boolean[][] visited = new boolean[m][n];

    // Compare heights to store the value
    PriorityQueue<Coordinates> pq = new PriorityQueue<>(
      (a, b) -> height[a.row][a.col] - height[b.row][b.col]
    );

    // push all the edge elements into the queue
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
          pq.offer(new Coordinates(i, j));
          visited[i][j] = true;
        }
      }
    }

    int water = 0;
    int max = Integer.MIN_VALUE;

    // visit the neighbors of the elements in the queue
    while (!pq.isEmpty()) {
      final Coordinates element = pq.poll();
      max = Math.max(max, height[element.row][element.col]);

      for (int i = 0; i < 4; i++) {
        final int x = element.row + DIRECTION[0][i];
        final int y = element.col + DIRECTION[1][i];
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
          continue;
        }
        pq.offer(new Coordinates(x, y));
        visited[x][y] = true;
      }

      water += Math.max(max - height[element.row][element.col], 0);
    }

    return water;
  }
}
