package anything.leetcode.easy;

public class Problem31 {


    class Solution {

        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] ans = new int[m + n];
            int x = 0;
            int y = 0;
            for (int i = 0; i < ans.length; i++) {
                if (x < m && (y >= nums2.length || nums1[x] < nums2[y])) {
                    ans[i] = nums1[x++];
                } else {
                    ans[i] = nums2[y++];
                }
            }
            for(int i = 0; i < nums1.length; i ++){
                nums1[i] = ans[i];
            }
        }




    }


}
