package anything.leetcode.easy;

public class Problem18 {
    class Solution {
        public String countAndSay(int n) {
            int num = 1;
            String info = String.valueOf(num);
            while(--n > 0){
                info = getnext(info);
            }
            return info;
        }

        private String getnext(String n){
            String info = n;
            StringBuilder stringBuilder = new StringBuilder();

            for(int i = 0;i < info.length(); ){
                char c = info.charAt(i);
                int num = 1;
                for(int j = i + 1; j < info.length(); j ++){
                    if(info.charAt(i) == info.charAt(j)){
                        num ++;
                    }else {
                        break;
                    }
                }
                i += num;
                stringBuilder.append(String.valueOf(num)+c);
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Problem18().new Solution();
        String s = solution.countAndSay(1);
        System.out.println(s);
    }


}
