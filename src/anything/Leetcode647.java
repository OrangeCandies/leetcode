package anything;

public class Leetcode647 {

    class Solution {
        public int countSubstrings(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }

            int len = s.length();
            boolean [][] ans = new boolean[len][len];
            int count = 0;
            for(int i =0 ; i < len; i ++){
                ans[i][i] = true;
            }
            count += len;
            char [] chars = s.toCharArray();
            for(int i =1; i < len; i ++){
                for(int j =0; j < len-i; j++){
                    int to = i + j;

                    if(chars[to] != chars[j]){
                        ans[j][to] = false;
                    }else{
                        ans[j][to] = getAns(ans,j+1,to-1);
                    }

                    if(ans[j][to]){
                        count++;
                    }

                }
            }
            return count;
        }

        private boolean getAns(boolean[][] ans,int j , int k){
            if(k <= j){
                return true;
            }else {
                return ans[j][k];
            }
        }
    }


}
