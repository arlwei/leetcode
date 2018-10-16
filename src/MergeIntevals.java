import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * title:
 * 56. Merge Intervals
 * <p>
 * content:
 * Given a collection of intervals, merge all overlapping intervals.
 */
public class MergeIntevals {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        if (intervals.size() == 0)
            return intervals;

        List<Interval> mergedList = new ArrayList<>(intervals.size());
        Interval current = new Interval(intervals.get(0).start, intervals.get(0).end);
        mergedList.add(current);
        for(int i = 1; i < intervals.size(); i++)
        {
            Interval temp = intervals.get(i);
            if(current.end >= temp.start)
            {
                if(current.end < temp.end)
                {
                    current.end = temp.end;
                }
            }
            else
            {
                current = new Interval(temp.start, temp.end);
                mergedList.add(current);
            }
        }

        return mergedList;
    }
}
