package anything.leetcode.easy;

public class Problem19 {

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            String pre = null;
            for (String s : strs) {
                if (pre == null) {
                    pre = s;
                    continue;
                } else {
                    int i =0 ;
                    for (i = 0; i < pre.length()&& i < s.length(); i++){
                        if(s.charAt(i) != pre.charAt(i)){
                            pre = pre.substring(0,i);
                            continue;
                        }
                    }
                    if(i == Math.min(pre.length(),s.length()))
                        pre = pre.substring(0,i);
                }
            }
            return pre;
        }
    }
}
