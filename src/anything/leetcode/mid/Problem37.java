package anything.leetcode.mid;

public class Problem37 {
    class Solution {
        public int titleToNumber(String s) {
            if(s == null || s.length() == 0) {
                return 0;
            }
            char[] chars = s.toCharArray();
            int ans = 0;
            for(int i = 0; i < chars.length; i++) {
                ans = ans * 26 + chars[i] - 'A' + 1;
            }

            return ans;

        }
    }


    public static void main(String[] args) {
        Solution solution = new Problem37().new Solution();
        int a = solution.titleToNumber("A");
        System.out.println(a);

        int zy = solution.titleToNumber("ZY");
        System.out.println(zy);
    }
}
