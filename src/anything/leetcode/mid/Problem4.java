package anything.leetcode.mid;

import java.util.HashSet;
import java.util.Set;

public class Problem4 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            Set<Character> set = new HashSet<>();
            int begin = 0;
            int end = 0;
            int longth = 0;
            for (end = 0; end < s.length();) {
                if (set.contains(s.charAt(end))) {
                    set.remove(s.charAt(begin));
                    begin++;
                } else {
                    set.add(s.charAt(end));
                    end++;
                }

                if (end - begin  > longth) {
                    longth = end - begin;
                }

            }
            return longth;
        }
    }

}
