package anything;

import java.util.Stack;

public class Leetcode443 {

    class Solution {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> stack = new Stack<>();
        public int compress(char[] chars) {

            if(chars ==  null || chars.length == 0){
                return 0;
            }
            for(char c : chars){
                if(stack.empty()){
                    stack.push(c);
                    numbers.push(1);
                    continue;
                }
                if(stack.peek().equals(c)){
                    int pop = numbers.pop();
                    numbers.add(++pop);
                }else{
                    stack.push(c);
                    numbers.push(1);
                }
            }
            String ans  = "";
            while(!stack.empty()){
                ans += stack.pop();
                ans += numbers.pop();
            }
            chars = ans.toCharArray();
            return ans.length();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode443().new Solution();

        char[] data = new char[]{'a','a','b','b','c','c','c'};
        int compress = solution.compress(data);
        System.out.println(compress);
    }
}
