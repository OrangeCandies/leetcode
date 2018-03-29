package anything;

import java.util.HashSet;
import java.util.Set;

public class Leetcode3 {

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

    public static void main(String[] args) {
        Solution solution = new Leetcode3().new Solution();
        int abcabcbb = solution.lengthOfLongestSubstring("aab");
        System.out.println(abcabcbb);
    }

}
