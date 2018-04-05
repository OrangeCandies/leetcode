package anything.leetcode.easy;

import anything.TreeNode;

public class Problem30 {

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if(nums == null || nums.length == 0){
                return null;
            }
            return getTree(nums,0,nums.length-1);
        }

        private TreeNode getTree(int[] nums, int l, int r) {
            if (r < l) {
                return null;
            }
            if (r == l) {
                TreeNode treeNode = new TreeNode(nums[l]);
                return treeNode;
            }
            int mid = l + (r - l) / 2;
            TreeNode treeNode = new TreeNode(nums[mid]);
            treeNode.left = getTree(nums, l, mid - 1);
            treeNode.right = getTree(nums, mid + 1, r);
            return treeNode;
        }
    }

}
