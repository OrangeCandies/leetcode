package anything;

import java.util.Stack;

public class Offer21 {
    static class NewStack<T extends Comparable>{
        Stack<T> data = new Stack<>();
        Stack<T> min = new Stack<>();

        public  T getMin(){
            assert min.size() > 0;
            return min.peek();
        }

        @SuppressWarnings("unchecked")
        public void push(T value){
            if(data.size() == 0 ||value.compareTo(min.peek()) <= 0){
                min.push(value);
                data.push(value);
            }else{
                min.push(min.peek());
                data.push(value);
            }
        }

        public T pop(){
            T value = data.pop();
            min.pop();
            return value;
        }
    }

    public static void main(String[] args) {
        NewStack<Integer> stack = new NewStack<>();

        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.pop()+" "+stack.min);
        System.out.println(stack.pop()+" "+stack.min);

    }

}
