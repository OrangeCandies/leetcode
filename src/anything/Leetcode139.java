package anything;

import java.util.*;

public class Leetcode139 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            boolean[] ans = new boolean[s.length() + 1];

            int size = s.length();
            for (int i = 0; i <s.length(); i++) {
                if (set.contains(s.substring(i, s.length()))) {
                    ans[i] = true;
                }
            }
            for(int i = size-1; i >= 0; i--){
                for(int j=size; j>i; j--){
                    ans[i] = ans[i] || ans[j]&&set.contains(s.substring(i,j));
                }
            }

            return ans[0];

        }
    }

    public static void main(String[] args) {
        List<String> s = Arrays.asList(new String[]{"Le", "et", "co", "de"});

        Leetcode139 leetcode139 = new Leetcode139();
        Solution solution = leetcode139.new Solution();
        boolean leetcode = solution.wordBreak("Leetcode", s);
        System.out.println(leetcode);
    }
}
