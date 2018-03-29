package anything.leetcode.easy;

public class Problem7 {

    class Solution {
        public int[] plusOne(int[] digits) {
            if(digits == null || digits.length == 0){
                return null;
            }
            int flag = 1;
            for(int i = digits.length -1 ; i >= 0; i --){
                int temp = flag;
                flag = (digits[i] + flag) / 10;
                digits[i] = (digits[i] + temp) % 10;

            }

            if(flag == 1){
                int [] newAnswer = new int[digits.length+1];
                newAnswer[0] = 1;
                digits = newAnswer;
            }
            return digits;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Problem7().new Solution();
        int [] testData = new int[]{9,9,9,9,9,9};
        int[] ints = solution.plusOne(testData);
        for(int i : ints){
            System.out.println(i);
        }
    }


}


