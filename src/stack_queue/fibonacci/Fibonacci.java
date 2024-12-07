package stack_queue.fibonacci;

import java.util.Stack;

public class Fibonacci {

    public static int solution(int num) {
        if(num <= 1) return 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(num);
        int result = 0;

        while(!stack.isEmpty()){
            int curr = stack.pop();
            if(curr <= 1){
                result += curr;
            } else {
                stack.push(curr-1);
                stack.push(curr-2);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int num = 10;
        int result = solution(num);
        System.out.println(result);
    }

}
