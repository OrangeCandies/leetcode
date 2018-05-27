package anything.leetcode.mid;

import anything.TreeNode;

import java.util.LinkedList;

public class Problem33 {

        static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder stringBuilder = new StringBuilder();
            if(root == null ) {
                return "";
            }
            LinkedList<TreeNode> linkedList = new LinkedList<>();
            linkedList.add(root);
            int l = 0;
            int r = 0;
            for(int i = l ; i <= r; i ++ ) {
                TreeNode o = linkedList.get(i);
                if(o == null ) {
                    stringBuilder.append("null,");
                    continue;
                }else{
                    stringBuilder.append(o.val+",");
                    linkedList.add(o.left);
                    linkedList.add(o.right);

                    r += 2;
                }
            }

            return stringBuilder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data == null || data.length() == 0) {
                return null;
            }
            String[] split = data.split(",");
            LinkedList<TreeNode> linkedList = new LinkedList<>();
            int l = 0, r = 0, index = 0;
            int val = Integer.parseInt(split[index++]);
            TreeNode root = new TreeNode(val);
            linkedList.add(root);
            for(int i = l ; i <= r && index < split.length; i ++) {
                if(split[index].equals("null")) {
                    linkedList.get(i).left = null;
                }else{
                    int v = Integer.parseInt(split[index]);
                    TreeNode left = new TreeNode(v);
                    linkedList.get(i).left = left;
                    linkedList.add(left);
                    r++;
                }
                index ++ ;
                if(split[index].equals("null")) {
                    linkedList.get(i).right = null;
                }else {
                    int v = Integer.parseInt(split[index]);
                    TreeNode right = new TreeNode(v);
                    linkedList.get(i).right = right;
                    linkedList.add(right);
                    r++;
                }
                index ++;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        String serialize = codec.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = codec.deserialize(serialize);
        String serialize1 = codec.serialize(deserialize);
        System.out.println(serialize1);
    }
}
