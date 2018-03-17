package anything;

public class Leetcode344 {
    class Solution {
        public String reverseString(String s) {
            char[] data = new char[s.length()];
            for(int i =0 ; i < data.length; i ++){
                data[i] = s.charAt(s.length()-1-i);
            }
            return new String(data);
        }
    }
}
