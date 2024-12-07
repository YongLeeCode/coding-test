package stack_queue.baseball_game;

import java.util.Stack;

public class BaseballGame {

    public static int solution(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String operation : operations) {
            if (operation.equals("+")) {
                int prev = stack.pop();
                int newNum = prev + stack.peek();
                stack.push(prev);
                stack.push(newNum);
            } else if (operation.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (operation.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(operation));
            }
        }
        int sum = 0;
        while(!stack.empty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        int result = solution(ops);
        System.out.println(result);
    }
}
