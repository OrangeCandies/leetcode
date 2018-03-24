package anything;

import java.util.HashMap;
import java.util.Map;

public class Leetcode792 {

    class Solution {
        public int numMatchingSubseq(String S, String[] words) {
            int count = 0;
            Map<String,Integer> set = new HashMap();

            for(String s : words){
                if(set.containsKey(s)){
                    int number = set.get(s);
                    set.put(s,number+1);
                }else {
                    set.put(s,1);
                }
            }


            for(Map.Entry<String,Integer> entry: set.entrySet()){
                if(isSubsequence(entry.getKey(),S)){
                    count += entry.getValue();
                }
            }



            return count;
        }

        public boolean isSubsequence(String s, String t) {

            if(t == null ){
                return false;
            }

            if(s == null || s.length()==0){
                return true;
            }
            boolean flag = false;
            char[] macher = s.toCharArray();
            char[] data = t.toCharArray();
            int pos = 0;
            int count = 0;
            for(int i = 0; i < macher.length; i ++){
                for(;pos < data.length; pos ++){
                    if(macher[i] == data[pos]){
                        pos ++;
                        count++;
                        break;
                    }
                }
                if(count == macher.length){
                    flag = true;
                }

                if(pos == data.length){
                    break;
                }
            }
            return flag;
        }


    }
}
