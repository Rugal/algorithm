package ga.rugal.hacker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.util.Pair;

/**
 * https://leetcode.com/problems/relative-ranks/
 *
 * @author rugal
 */
public class RelativeRanks {

    private static final String[] MEDALS = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};

    public String[] findRelativeRanks(int[] nums) {
        if (0 == nums.length) {
            return null;
        }
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            list.add(new Pair<>(i, nums[i]));
        }

        Collections.sort(list, (Pair<Integer, Integer> a, Pair<Integer, Integer> b) -> b.getValue() - a.getValue());
        for (int i = 0; i < list.size(); i++) {
            result[list.get(i).getKey()] = Integer.toString(i + 1);
        }
        for (int i = 0; i < Math.min(3, nums.length); i++) {
            result[list.get(i).getKey()] = MEDALS[i];
        }

        return result;
    }
}
