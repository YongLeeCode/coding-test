package stack_queue.parentheses_rotation;

import java.util.Stack;

public class ParenthesesRotation {

    public static int solution(String s) {

        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.contains(c)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "[](){}[}";
        int result = solution(s);
        System.out.println(result);
    }
}
