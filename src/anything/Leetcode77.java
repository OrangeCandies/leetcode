package anything;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Leetcode77 {
    class Solution {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(12);
        CountDownLatch downLatch = new CountDownLatch(12);
        List<List<Integer>> answer = new ArrayList<>();
        public List<List<Integer>> combine(int n, int k) {
            List<Integer> ans = new ArrayList<>();
            generatio(n,k,1,ans);
            return answer;
        }

        private void generatio(int C, int k, int start, List<Integer> ans) {
            if (ans.size() == k) {
                List a = new ArrayList(ans);
                answer.add(a);
                return;
            }
            for (int i = start; i <= C; i++) {
                ans.add(i);
                generatio(C,k,i+1,ans);
                ans.remove(ans.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode77().new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
        for(List s: combine){
            for(Object i:s){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
