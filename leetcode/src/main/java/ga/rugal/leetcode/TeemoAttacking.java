package ga.rugal.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rugal
 */
public class TeemoAttacking {

    public int findPoisonedDuration(int[] input, int durationInput) {
        if (input.length == 0) {
            return 0;
        }

        Set<Integer> timeSeries = new HashSet<>(input.length);
        for (int i = 0; i < input.length; i++) {
            timeSeries.add(input[i]);
        }

        int totalTime = 0;
        int duration = -1;
        for (int i = input[0]; !timeSeries.isEmpty() || duration != 0; i++) {
            if (timeSeries.contains(i)) {
                timeSeries.remove(i);
                duration = durationInput;
            }
            if (duration > 0) {
                totalTime++;
                duration--;
            }
            if (!timeSeries.isEmpty() && duration == 0) {
                duration = -1;
            }
        }

        return totalTime;
    }
}
