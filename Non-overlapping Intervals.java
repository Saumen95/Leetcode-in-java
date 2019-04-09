import java.util.Comparator;

import org.graalvm.compiler.lir.alloc.lsra.Interval;

class Solution
{
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        
         Arrays.sort(intervals, new Comparator<Interval>() {
             public int compare(Interval o1, Interval o2) {
                 return o1.end - o2.end;
             }
         });
         
         int count = 1;
         int last = 0;
         for (int i = 1; i < intervals.length; i++) {
             if (intervals[last].end <= intervals[i].start) {
                 count++;
                 last = i;
             }
         }
         return intervals.length - count;
        }
}