package anything.leetcode.mid;

import java.util.*;

public class Problem3 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String,List<String>> map = new HashMap<String,List<String>>();

            for(String s: strs){
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String key= new String(chars);
                if(map.containsKey(key)){
                    List<String> strings = map.get(key);
                    strings.add(s);
                }else{
                    List<String> l = new ArrayList<>();
                    l.add(s);
                    map.put(key,l);
                }
            }
            List<List<String>> lists = new ArrayList<>();
            for(Map.Entry<String,List<String>> entry : map.entrySet()){
                lists.add(entry.getValue());
            }
            return lists;
        }
    }

}
