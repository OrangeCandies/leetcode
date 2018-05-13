package anything.leetcode.mid;

import java.util.*;

public class Problem22 {

    class Solution {

        class Two{
            int times;
            int target;
            Two(int times, int val){
                this.times = times;
                this.target = val;
            }
        }
        public List<Integer> topKFrequent(int[] nums, int k) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i : nums) {
                if(map.containsKey(i)){
                    Integer integer = map.get(i);
                    map.put(i,integer+1);
                }else{
                    map.put(i,1);
                }
            }

            PriorityQueue<Two> queue = new PriorityQueue<Two>((t1, t2) -> t2.times - t1.times);
            for(HashMap.Entry<Integer,Integer> entry : map.entrySet()){
                Integer key = entry.getKey();
                Integer val = entry.getValue();
                Two two = new Two(val,key);
                queue.add(two);
            }
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i<k;i++){
                l.add(queue.poll().target);
            }
            return l;
        }
    }
}
