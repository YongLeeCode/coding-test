package exam3;

import java.util.Stack;

public class RemoveTogether {
    public static int solution(String s) {

        Stack<Character> stack = new Stack<>();
        for(char word : s.toCharArray()) {
            if(!stack.isEmpty() && word == stack.peek()) {
                System.out.println(word);
                stack.pop();
            } else {
                System.out.println(word);
                stack.push(word);
            }

        }
        return stack.size() > 0 ? 0 : 1;
    }

    private static int isValid(StringBuffer s) {
        char prev = '0';
        for(int i = 0; i < s.length(); i++) {
            if(prev == s.charAt(i)) {
                return i - 1;
            } else {
                prev = s.charAt(i);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "baabaa";
        int result = solution(s);
        System.out.println(result);
    }
}



// 시간 초과
//public static int solution(String s) {
//
//    StringBuffer str = new StringBuffer(s);
//    while(isValid(str) != -1) {
//        str.delete(isValid(str), isValid(str) + 2);
//        System.out.println(str.toString());
//    }
//
//    return str.isEmpty() ? 1 : 0;
//}
//
//private static int isValid(StringBuffer s) {
//    char prev = '0';
//    for(int i = 0; i < s.length(); i++) {
//        if(prev == s.charAt(i)) {
//            return i - 1;
//        } else {
//            prev = s.charAt(i);
//        }
//    }
//    return -1;
//}