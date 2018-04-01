package anything.leetcode.easy;

public class Problem15 {

    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }
            s = s.toLowerCase();
            s = s.trim();
            int l = 0;
            int r = s.length() - 1;
            while (l <= r) {
                while (l <= r && !(Character.isAlphabetic(s.charAt(l)) || Character.isDigit(s.charAt(l)))) {
                    l++;
                }
                while (l <= r && !(Character.isAlphabetic(s.charAt(r)) || Character.isDigit(s.charAt(r)))){
                    r--;
                }
                if (l <= r && s.charAt(l) != s.charAt(r)) {
                    return false;
                } else {
                    l++;
                    r--;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Problem15().new Solution();
        boolean palindrome = solution.isPalindrome("0p");
        System.out.println(palindrome);
    }
}
