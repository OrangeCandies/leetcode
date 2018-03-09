package anything;

public class Leetcode660 {
    class Solution {
        public String tree2str(TreeNode t) {

            if(t == null){
                return "";
            }
            String s = tree2str(t, "");

            return s.substring(1,s.length()-1);

        }

        private String tree2str(TreeNode t,String str){
            if(t.left == null && t.right == null){
                return str += "("+t.val+")";
            }
            if(t.left != null){
                str+= "("+t.val+tree2str(t.left,"");
            }else{
                str += "("+t.val+"()";
            }
            if(t.right != null){
                str += tree2str(t.right,"");
            }
            str += ")";
            return str;
        }
    }

    public static void main(String[] args) {
        Leetcode660 leetcode660 = new Leetcode660();
        Solution solution = leetcode660.new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        String s = solution.tree2str(root);
        System.out.println(s);
    }
}

