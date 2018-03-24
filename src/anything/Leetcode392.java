package anything;

public class Leetcode392 {

    class Solution {
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

    public static void main(String[] args) {
        Solution solution = new Leetcode392().new Solution();
        boolean subsequence = solution.isSubsequence("bcd",
                "uuubcd");
        System.out.println(subsequence);
    }

}
