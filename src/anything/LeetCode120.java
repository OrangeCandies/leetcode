package anything;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode120 {
    public static void main(String[] args) {
        List<List<Integer>> test  = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(-10);
        test.add(row1);
        HashMap

        Solution2 solution = new Solution2();
        System.out.println(solution.minimumTotal(test));
    }
}
// 249

class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int size = triangle.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--){
            for(int j=0;j<=i;j++){
                if(i == size-1){
                    ans[j] = triangle.get(i).get(j);
                }else {
                    ans[j] = Math.min(ans[j],ans[j+1])+triangle.get(i).get(j);
                }
            }
        }
        return ans[0];
    }
}