package anything.didi;

public class Problem3 {

    public static int getMaxSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if(sum > maxSum){
                    maxSum = sum;
                }

            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int [] testData  = new int[]{-2,11,-4,13,-5,2};
        System.out.println(getMaxSum(testData));
    }
}
