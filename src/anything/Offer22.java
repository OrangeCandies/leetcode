package anything;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Offer22 {

    public static<T extends Comparable> boolean function(List<T> push,List<T> pop){
        if(push == null || pop == null || push.size() != pop.size()){
            return false;
        }
        Stack<T> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex =0;
        while(popIndex < pop.size() && pushIndex < pop.size()){
            if(stack.size() == 0 || stack.peek().compareTo(pop.get(popIndex))!=0){
                stack.push(push.get(pushIndex++));
            }else{
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        List<Integer> push = Arrays.asList(1,2,3,4,5);
        List<Integer> pop = Arrays.asList(4,5,2,3,1);
        System.out.println(function(push,pop));
    }
}
