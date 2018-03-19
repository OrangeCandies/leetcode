package anything;

public class Leetcode56 {

    class Solution {
        public int lengthOfLastWord(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int length = 0;
            int i = 0;
            for (i = s.length()-1; i >= 0; i--){
                if(s.charAt(i) != ' '){
                    break;
                }
            }
                for (; i >= 0; i--) {
                    if (s.charAt(i) != ' ') {
                        length++;
                    } else {
                        return length;
                    }
                }
            return length;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode56().new Solution();
        int a = solution.lengthOfLastWord("a");
        System.out.println("a".lastIndexOf(' '));
        System.out.println(a);
    }
}
