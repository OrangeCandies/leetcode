package stack;

import java.util.Stack;

public class ReversePolishExpress {

    public static void main(String[]args){
        String[] expression = new String[]{"2", "1", "+","3","*"};
        System.out.println(new ReversePolishExpress().evalRPN(expression));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens){
            try{
                int num = Integer.parseInt(s);
                stack.push(num);
            }catch (Exception e){
                int a = stack.pop();
                int b = stack.pop();
                if(s.equals("*")){
                    stack.push(a*b);
                }else if(s.equals("/")){
                    stack.push(b/a);
                }else if(s.equals("+")){
                    stack.push(a+b);
                }else{
                    stack.push(b-a);
                }
            }

        }
        return stack.peek();
    }
}
