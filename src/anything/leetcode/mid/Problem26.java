package anything.leetcode.mid;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem26 {


    static class Interval {
        int start;
        int end;
    }

    class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            LinkedList<Interval> list = new LinkedList();
            if(intervals == null || intervals.size() == 0) {
                return list;
            }
            Collections.sort(intervals,(e1, e2) -> e1.start - e2.start);

            list.add(intervals.get(0));
            for(int i = 1; i < intervals.size(); i ++ ) {
                if(list.peekLast().end < intervals.get(i).start) {
                    list.add(intervals.get(i));
                }else{
                    list.peekLast().end = Math.max(list.peekLast().end,intervals.get(i).end);
                }
            }
            return list;
        }
    }
}
