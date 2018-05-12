package anything.leetcode.mid;

import java.util.Arrays;

public class Problem21 {

    class Solution {
        public void sortColors(int[] nums) {
            int num0 = 0;
            int num1 = 0;
            int num2 = 0;
            for(int i :nums){
                if(i == 0){
                    num0 ++;
                }else if(i == 1){
                    num1 ++;
                }else  if(i == 2){
                    num2++;
                }
            }
            int pos = 0;
            while(num0-- >0 ){
                nums[pos++] = 0;
            }
            while(num1-- >0 ){
                nums[pos++] = 1;
            }
            while(num2-- >0 ){
                nums[pos++] = 2;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Problem21().new Solution();
        int [] dtest = new int[]{2,0,2,1,1,0};
        solution.sortColors(dtest);
        Arrays.asList(dtest).stream().forEach(e -> System.out.println(e));
    }

}
