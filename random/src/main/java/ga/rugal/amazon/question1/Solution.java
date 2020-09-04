package ga.rugal.amazon.question1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
// CLASS BEGINS, THIS CLASS IS REQUIRED

public class Solution {

  private static class Point implements Comparable<Point> {

    public int x;

    public int y;

    public double distance;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
      this.distance = Math.sqrt(x * x + y * y);
    }

    @Override
    public int compareTo(Point o) {
      return this.distance < o.distance
             ? -1
             : 1;
    }

  }
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED

  List<List<Integer>> ClosestXdestinations(int numDestinations,
                                           List<List<Integer>> allLocations,
                                           int numDeliveries) {
    List<Point> temp = new ArrayList<>();
    // WRITE YOUR CODE HERE
    for (int i = 0; i < numDestinations; ++i) {
      temp.add(new Point(allLocations.get(i).get(0), allLocations.get(i).get(1)));
    }
    Collections.sort(temp);

    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < numDeliveries; ++i) {
      result.add(Arrays.asList(temp.get(i).x, temp.get(i).y));
    }
    return result;
  }
  // METHOD SIGNATURE ENDS
}
