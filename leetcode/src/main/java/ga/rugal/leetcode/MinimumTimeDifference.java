package ga.rugal.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author rugal
 */
public class MinimumTimeDifference {

    private static final int DAY = 24 * 60;

    public int findMinDifference(List<String> timePoints) {

        Collections.sort(timePoints, new StringComparator());
        List<Integer> list = new ArrayList<>(timePoints.size());
        for (int i = 0; i < timePoints.size(); i++) {
            String[] t = timePoints.get(i).split(":");
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);
            list.add(h * 60 + m);
        }

        int min = Math.abs(list.get(0) - list.get(list.size() - 1));
        min = Math.min(min, DAY - min);
        for (int i = 0; i < list.size() - 1; i++) {
            int diff = Math.abs(list.get(i) - list.get(i + 1));
            min = Math.min(min, diff);
        }

        return min;
    }
}

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String a, String b) {

        String[] t1 = a.split(":");
        String[] t2 = b.split(":");

        return !t1[0].equals(t2[0])
               ? t1[0].compareTo(t2[0])
               : t1[1].compareTo(t2[1]);
    }
}
