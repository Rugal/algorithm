package ga.rugal.amazon.question2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// CLASS BEGINS, THIS CLASS IS REQUIRED

public class Solution {

  private static class Point {

    int x, y;

    public Point(final int x, final int y) {
      this.x = x;
      this.y = y;
    }
  }

  private static class Pair {

    Point point;

    int distance;

    public Pair(final Point point, final int distance) {
      this.point = point;
      this.distance = distance;
    }
  }

  // These arrays are used to get row and column numbers
  // of 8 neighbors of a given cell
  private static final int ROW_NEIBOUGH[] = new int[]{-1, 0, 0, 1};

  private static final int COL_NEIBOUGH[] = new int[]{0, -1, 1, 0};

  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  private boolean isSafe(List<List<Integer>> lot, int row, int col, boolean visited[][]) {
    // row number is in range, column number is in range
    // and value is 1 and not yet visited
    return (row >= 0) && (row < visited.length)
           && (col >= 0) && (col < visited[0].length)
           && lot.get(row).get(col) != 0
           && !visited[row][col];
  }

  private boolean isValid(final int x, final int y, final int[][] lot) {
    return 0 <= x && x < lot.length
           && 0 <= y && y < lot[0].length;
  }

  private int bfs(final int[][] lot, final Point begin, final Point end) {
    if (0 == lot[begin.x][begin.y]
        || 0 == lot[end.x][end.y]) {
      return -1;
    }
    final boolean[][] visited = new boolean[lot.length][lot[0].length];
    visited[begin.x][begin.y] = true;
    final Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(begin, 0));
    while (!queue.isEmpty()) {
      final Pair head = queue.poll();

      if (head.point.x == end.x && head.point.y == end.y) {
        return head.distance;
      }

      for (int i = 0; i < ROW_NEIBOUGH.length; ++i) {
        final int nextX = head.point.x + ROW_NEIBOUGH[i];
        final int nextY = head.point.y + COL_NEIBOUGH[i];
        if (this.isValid(nextX, nextY, lot)
            && lot[nextX][nextY] == 1
            && visited[nextX][nextY]) {
          visited[nextX][nextY] = true;
          queue.add(new Pair(new Point(nextX, nextY), head.distance));
        }
      }
    }

    return -1;
  }
  // METHOD SIGNATURE ENDS
}
