package anything;

public class Leetcode561 {
    class Solution {
        public int arrayPairSum(int[] nums) {


            sort(nums,0,nums.length-1);
            int ans = 0;
            for(int i =0; i < nums.length; i++){
                System.out.println(nums[i]);
            }
            for(int i = 0; i < nums.length; i+=2){
                ans += nums[i];
            }

            return ans;
        }

        private void sort(int[] nums,int l,int r){
            if(r <= l){
                return;
            }
            int i = l;
            int j = r;
            int pos = nums[i];
            while(i < j ){
                while(i < j && nums[j] > pos){
                    j--;
                }
                if( i < j ){
                    nums[i++] = nums[j];
                }
                while(i < j && nums[i] < pos){
                    i++;
                }
                if(i < j){
                    nums[j--] = nums[i];
                }
            }
            nums[i] = pos;
            sort(nums,l,i-1);
            sort(nums,i+1,r);
        }
    }
}
