package stack_queue.valid_parentheses;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static boolean solution(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if(stack.empty()){
                    return false;
                }
                char out = stack.pop();
                if(map.get(c) != out) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
    public static void main(String[] args) {

    }
}
