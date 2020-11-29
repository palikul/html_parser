package pentalog.hack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public final class Interval {

    private long startTime;
    private long endTime;

    public Interval(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public static void main(String[] args) {
        List<Interval> intervalList = Arrays.asList(new Interval(1, 5),
                new Interval(1, 2),
                new Interval(11, 14),
                new Interval(4, 7),
                new Interval(1, 3),
                new Interval(7, 9),
                new Interval(13, 14)
        );
        getMaxInterval(intervalList);
    }

    public static long getMaxInterval(List<Interval> intervalList) {
        Collection<Interval> intervals = new ArrayList<>(intervalList);

        List<Interval> intervalsSortedByStartTime = intervals.stream()
                .sorted((o1, o2) -> Long.valueOf(o1.getStartTime() - o2.getStartTime()).intValue())
                .collect(Collectors.toList());

        System.out.println(intervalsSortedByStartTime);

        Interval maxInterval = intervalsSortedByStartTime.get(intervalsSortedByStartTime.size() - 1);
        long maxSize = maxInterval.getEndTime() - maxInterval.getStartTime();

        for (int i = 0; i < intervalsSortedByStartTime.size(); i++) {
            Interval currentInterval = intervalsSortedByStartTime.get(i);
            for (int j = 1; j < intervalsSortedByStartTime.size(); j++) {
                Interval internalInterval = intervalsSortedByStartTime.get(j);

                if (currentInterval.getEndTime() > internalInterval.getStartTime() && currentInterval.getEndTime() < internalInterval.getEndTime()) {
                    if (maxSize < (internalInterval.getEndTime() - currentInterval.getStartTime())) {
                        maxSize = internalInterval.getEndTime() - currentInterval.getStartTime();
                    }
                }
            }
        }
        System.out.println(maxSize);
        return maxSize;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
