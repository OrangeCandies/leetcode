package anything;

import java.util.Arrays;

public class Leetcode108 {

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            Arrays.sort(nums);
            if(nums == null || nums.length == 0){
                return null;
            }
            return getNode(nums,0,nums.length-1);
        }
        private TreeNode getNode(int [] nums, int l, int r){
            if(l > r){
                return null;
            }

            if(l == r){
                return new TreeNode(nums[l]);
            }
            int mid = l+(r-l)/2;
            TreeNode result = new TreeNode(nums[mid]);
            result.left = getNode(nums,l,mid-1);
            result.right = getNode(nums,mid+1,r);
            return result;
        }
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
