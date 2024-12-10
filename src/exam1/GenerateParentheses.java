package exam1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> arr = new ArrayList<>();

        arr = makeParenthesis(n, '(', arr, 1, 0, "");
        ArrayList<String> result = new ArrayList<>();

        for(String p : arr) {
            if(isCorrect(p)){
                result.add(p);
            }
        }

//        return parenthesis(3, 0, "");

        return result;
    }
    private static ArrayList<String> makeParenthesis(int n, char c, ArrayList<String> arr, int openCount, int closeCount, String str) {
        if(openCount > n) return arr;
        if(closeCount > n) return arr;

        str += c;
        makeParenthesis(n, '(', arr, openCount + 1, closeCount, str);
        makeParenthesis(n, ')', arr, openCount, closeCount + 1, str);
        if(str.length() != n*2) {
            return arr;
        }
        arr.add(str);
        return arr;
    }

//    private static String parenthesis(int n, int openCount, String result) {
//        if (result.length() >= n * 2) {
//            return result;
//        }
//
//        if (openCount < n) {
//            return parenthesis(n, openCount + 1, result + "(");
//        }
//        if (result.length() - openCount < openCount) {
//            return parenthesis(n, openCount, result + ")");
//        }
//    }

    private static boolean isCorrect(String p){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < p.length(); i++){
            char c = p.charAt(i);
            if(c == '(') {
                stack.add(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }
    public static void main(String[] args) {
        List<String> result = generateParenthesis(1);
        System.out.println(result);
    }
}
