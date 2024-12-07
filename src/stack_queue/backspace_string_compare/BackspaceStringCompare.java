package stack_queue.backspace_string_compare;

import java.util.Stack;

public class BackspaceStringCompare {

    public static boolean solution(String s, String t) {
        Stack<Character> c1 = new Stack<>();
        Stack<Character> c2 = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '#' && !c1.empty()) {
                c1.pop();
            } else if(s.charAt(i) != '#') {
                c1.push(s.charAt(i));
            }
        }

        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == '#' && !c2.empty()) {
                c2.pop();
            } else if (t.charAt(i) != '#') {
                c2.push(t.charAt(i));
            }
        }

        if(c1.size() != c2.size()) {
            return false;
        } else {
            while(!c1.isEmpty()){
                char sChar = c1.pop();
                char tChar = c2.pop();
                if(sChar != tChar) {
                    return false;
                }
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        boolean result = solution(s, t);
        System.out.println(result);
    }
}
