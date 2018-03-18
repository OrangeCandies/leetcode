package anything;

public class Leetcode167 {

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int []ans = new int[2];
            int i = 0;
            int j = numbers.length-1;
            if(numbers == null || numbers.length == 0){
                return null;
            }
            while(i < j){
                if(numbers[i] + numbers[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }else if(numbers[i] + numbers[j] < target){
                    i++;
                }else{
                    j--;
                }
            }

            return ans;
        }
    }
}
