package anything;

public class Leetcode461 {
    class Solution {
        public int hammingDistance(int x, int y) {
            int ans = x ^ y;
            int count = 0;
            while (ans != 0){
                ans = ans & (ans-1);
                count++;
            }

            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode461().new Solution();
        int i = solution.hammingDistance(1, 4);
        System.out.println(i);
    }


}
