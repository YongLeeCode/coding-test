package stack_queue.evaluate_reverse_polish_notation;

import java.util.Objects;
import java.util.Stack;

public class EvaluteReversePolishNotation {
    public static int solution(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if(token.equals("-")) {
                stack.add(minus(stack));
            } else if (token.equals("+")) {
                stack.add(plus(stack));
            } else if (token.equals("*")) {
                stack.add(multiply(stack));
            } else if (token.equals("/")) {
                stack.add(divide(stack));
            } else {
                stack.add(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","-","3","*"};
        int result = solution(tokens);
        System.out.println(result);
    }

    public static int minus(Stack<Integer> stack){
        int num1 = stack.pop();
        int num2 = stack.pop();
        return num2 - num1;
    }

    public static int plus(Stack<Integer> stack) {
        int num1 = stack.pop();
        int num2 = stack.pop();
        return num2 + num1;
    }

    public static int multiply(Stack<Integer> stack){
        int num1 = stack.pop();
        int num2 = stack.pop();
        return num2 * num1;
    }

    public static int divide(Stack<Integer> stack){
        int num1 = stack.pop();
        int num2 = stack.pop();
        return num2 / num1;
    }


}
