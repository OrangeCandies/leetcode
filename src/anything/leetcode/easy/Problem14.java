package anything.leetcode.easy;

import java.util.Arrays;

public class Problem14 {

    class Solution {
        public boolean isAnagram(String s, String t) {
            char[] chars = s.toCharArray();
            char[] chars1 = t.toCharArray();
            Arrays.sort(chars);
            Arrays.sort(chars1);

            if(equals(chars1,chars)){
                return true;
            }else {
                return false;
            }

        }

        public boolean equals(char [] c1, char [] c2){
            if(c1 == null && c2 == null){
                return true;
            }
            if(c1.length != c2.length){
                return false;
            }

            for(int i = 0; i < c1.length; i ++){
                if(c1[i] != c2[i]){
                    return false;
                }
            }
            return true;
        }
    }


}
