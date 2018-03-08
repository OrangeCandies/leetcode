package anything;

import java.util.HashMap;
import java.util.Map;

public class Leetcode532 {
    class Solution {
        public int findPairs(int[] nums, int k) {
            Map map = new HashMap<Integer,Integer>();
            for( int i : nums){
                if(!map.containsKey(i)){
                    map.put(i,1);
                }else{
                    int val = (int) map.get(i);
                    map.put(i,val+1);
                }
            }
            int ans = 0;
            if(k == 0){
                for(int i: nums){
                    ans += ((int)map.get(i)-1);
                }
            }else{
                for(int i: nums){
                    if(map.containsKey(i-k)){
                        ans ++ ;
                    }
                    if(map.containsKey(i+k)){
                        ans ++;
                    }
                }
            }
            return ans/2;
        }
    }

}
