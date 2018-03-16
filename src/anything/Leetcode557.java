package anything;

public class Leetcode557 {
    class Solution {
        public String reverseWords(String s) {
            String[] split = s.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for(int i =0 ; i < split.length; i++){
                stringBuilder.append(resverse(split[i]));
            }
            return stringBuilder.toString().substring(0,stringBuilder.length()-1);
        }

        private String resverse(String s) {
            char [] chars = new char[s.length()];
            for(int i = 0; i < s.length(); i++){
                chars[i] = s.charAt(s.length()-i-1);
            }
            return new String(chars);
        }
    }
}
