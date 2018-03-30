package anything.didi;

public class Problem1 {

    public int find(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;
        // [l ,r]
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }else{
                l = mid - 1;
            }
        }
        return -1;
    }
}
