package anything.leetcode.easy;

public class Problem32 {

    class Solution {
        public int firstBadVersion(int n) {
            int l = 0;
            int r = n;
            int mid = l + (r - l) / 2;
            while (true) {
                mid = l + (r - l) / 2;
                if (mid - 1 >= 1 && isBadVersion(mid) && !isBadVersion(mid - 1) || mid == 1 && isBadVersion(mid)) {
                    return mid;
                } else if (isBadVersion(mid)){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }

            }
        }

        boolean isBadVersion(int version) {
            return true;
        }
    }


}
