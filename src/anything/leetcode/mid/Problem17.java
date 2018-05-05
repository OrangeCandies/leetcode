package anything.leetcode.mid;

import java.util.ArrayList;
import java.util.List;

public class Problem17 {

    class Solution {

        private List<String> ans = new ArrayList<>();
        public List<String> generateParenthesis(int n) {
            if(n <= 0){
                return ans;
            }else{
                char [] chars = new char[n*2];
                make(n,n,chars,0);
                return ans;
            }
        }

        private void make(int left, int right, char [] chars,int count){
            if(left < 0 || right < left) {
                return;
            }
            if(left == 0 && right == 0){
                ans.add(new String(chars));
            }else {
                if(left > 0 ){
                    chars[count] = '(' ;
                    make(left-1,right,chars,count+1);
                }
                if(right > left){
                    chars[count] = ')';
                    make(left, right-1,chars,count+1);
                }
            }

        }
    }
}
