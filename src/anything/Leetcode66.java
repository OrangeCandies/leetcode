package anything;

public class Leetcode66 {

    class Solution {
        public int[] plusOne(int[] digits) {
            int flag = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int temp = digits[i];
                digits[i] = (digits[i] + flag) % 10;
                flag = (temp + flag) / 10;

            }
            int[] ans = null;
            if (flag == 1) {
                ans = new int[digits.length + 1];
                ans[0] = flag;
                for (int i = 0; i < digits.length; i++){
                    ans[i+1] = digits[i];
                }
            }else{
                ans = digits;
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode66().new Solution();

        int[] ints = solution.plusOne(new int[]{9,9,9});
        for(int i : ints){
            System.out.println(i);
        }
    }
}
