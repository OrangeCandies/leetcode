package anything;

public class Leetcode541 {

    class Solution {
        public String reverseStr(String s, int k) {
            if (s == null || s.length() == 0){
                return "";
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < s.length(); i += 2*k) {
                int pos1 = i+k-1;
                if(pos1 > s.length()-1){
                    pos1 = s.length()-1;
                }
                ans.append(reverseStr(s,i,pos1));
                int pos = i+2*k;
                if(i+2*k > s.length() ){
                    pos = s.length();
                }
                ans.append(s.substring(pos1+1,pos));
            }
            return ans.toString();
        }

        private String reverseStr(String s, int l, int j) {
            char[] chars = s.substring(l,j+1).toCharArray();
            j -= l;
            l = 0;
            while (l < j) {
                char c = chars[l];
                chars[l] = chars[j];
                chars[j] = c;

                j--;
                l++;
            }
            return new String(chars);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode541().new Solution();
        String abcdefg = solution.reverseStr("a", 2);
        System.out.println(abcdefg);
    }


}
