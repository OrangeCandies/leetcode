package anything.leetcode.easy;

public class Problem42 {

    class Solution {
        public int romanToInt(String s) {
            int sum = 0;
            if(s == null || s.length() == 0){
                return 0;
            }
            char[] chars = s.toCharArray();
            for(int i =0;i < chars.length-1; i ++){
                if(getNumber(chars[i]) < getNumber(chars[i+1])){
                    sum -= getNumber(chars[i]);
                }else {
                    sum += getNumber(chars[i]);
                }
            }
            sum += getNumber(chars[chars.length-1]);
            return sum;
        }

        private int getNumber(char c) {
            switch (c){
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;

                    default:
                        return 0;
            }

        }


    }

    public static void main(String[] args) {
        Solution solution = new Problem42().new Solution();
        int viii = solution.romanToInt("VIII");
        System.out.println(viii);
    }
}
