package greedyAlgorithms;

import java.util.Comparator;
import java.util.List;

public class MaximumNumberOfNonOverlappingIntervals {

    public static int maximizeNonOverlappingMeetings(List<List<Integer>> meetings) {

        if (meetings.size() == 0) return 0;
        meetings.sort(Comparator.comparingInt(m -> m.get(1)));
        int res = 1;
        int lastEnd = meetings.get(0).get(1);
        for (int i = 1; i < meetings.size(); i++) {
            List<Integer> meeting = meetings.get(i);

            if (meeting.get(0) >= lastEnd) {
                res++;
                lastEnd = meeting.get(1);
            }
        }
        return res;
    }
}
