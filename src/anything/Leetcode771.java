package anything;

import java.util.HashSet;
import java.util.Set;

public class Leetcode771 {

    class Solution {
        public int numJewelsInStones(String J, String S) {
            if(J == null || J.length() == 0){
                return 0;
            }
            Set<Character> set = new HashSet<>();
            for(char c : J.toCharArray()){
                set.add(c);
            }
            int ans = 0;
            for(char c: S.toCharArray()){
                if(set.contains(c)){
                    ans ++;
                }
            }

            return ans;
        }
    }
}
