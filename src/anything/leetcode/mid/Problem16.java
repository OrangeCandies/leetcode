package anything.leetcode.mid;

import java.util.ArrayList;
import java.util.List;

public class Problem16 {
    class Solution {
        private String [] trim = new String[]{
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        private List<String> ans = new ArrayList<>();
        public List<String> letterCombinations(String digits) {
            if(digits == null || digits.length() == 0){
                return ans;
            }
            char[] temp = new char[digits.length()];
            getString(digits,temp,0);
            return ans;
        }

        private void getString(String digits,char[] chars, int depth){
            if(depth == digits.length()){
                ans.add(new String(chars));
                return;
            }
            int num = digits.charAt(depth) - '0';
            String info = trim[num];
            for(int i =0 ;i < info.length(); i ++){
                chars[depth] = info.charAt(i);
                getString(digits, chars, depth+1);
            }
        }

    }
}
