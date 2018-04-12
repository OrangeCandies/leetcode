package anything.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

public class Problem44 {

    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> list = new LinkedList<>();
            if(numRows == 0){
                return list;
            }
            for(int i = 0; i < numRows;i ++){
                List<Integer> rows = new LinkedList<>();
                for(int j = 0; j <=i ; j ++){
                    rows.add(getNumber(list,i,j));
                }
                list.add(rows);
            }
            return list;
        }

        private Integer getNumber(List<List<Integer>> integers, int i, int j) {
            if(i == 0){
                return 1;
            }else{
                if(j == 0 || j == integers.get(i-1).size()){
                    return 1;
                }else{
                    return  integers.get(i-1).get(j)+integers.get(i-1).get(j-1);
                }
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Problem44().new Solution();
        List<List<Integer>> generate = solution.generate(5);
        for(List<Integer> list : generate){
            for(Integer i : list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }


}
