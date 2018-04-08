package anything.leetcode.easy;

public class Problem40 {

    class Solution {
        public int countPrimes(int n) {
            boolean [] ans = new boolean[n];
            int count = 0;
            for(int i = 2; i < n; i ++){
                if(ans[i] == false){
                    count ++;
                }
                for(int j = 2; j * i < n; j ++){
                    ans[i*j] = true;
                }
            }
            return count;
        }
    }


}
