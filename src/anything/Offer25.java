package anything;

import java.util.ArrayList;
import java.util.List;

public class Offer25 {

    static class BinaryTreeNode{
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    private static ArrayList<ArrayList<Object>> ans = new ArrayList<>();
    public static ArrayList<ArrayList<Object>> getPath(BinaryTreeNode root, int value){
        if(root == null){
            return null;
        }
        getPathWithArraylist(new ArrayList<>(), root, value);
        return ans;

    }


    public static void getPathWithArraylist(List<Integer> onePath, BinaryTreeNode root,
                                                                      int value) {
        if(root.data == value){
            onePath.add(value);
            ArrayList<Object> answer = new ArrayList<>();
            copyList(answer,onePath);
            ans.add(answer);
        } else if(value < root.data){
            return;
        }else{
            onePath.add(root.data);
            if(root.left != null){
                getPathWithArraylist(onePath,root.left,value-root.data);
            }
            if(root.right != null){
                getPathWithArraylist(onePath,root.right,value-root.data);
            }
            onePath.remove(onePath.size()-1);
        }

    }

    private static void copyList(ArrayList<Object> path, List<Integer> onePath) {
        for(int i:onePath){
            path.add(i);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode p1 = new BinaryTreeNode(5);
        BinaryTreeNode p2 = new BinaryTreeNode(4);
        BinaryTreeNode p3 = new BinaryTreeNode(7);
        BinaryTreeNode p4 = new BinaryTreeNode(12);

        root.right = p4;
        root.left = p1;
        p1.left = p2;
        p1.right = p3;


        System.out.println(getPath(root,22).size());

    }
}
