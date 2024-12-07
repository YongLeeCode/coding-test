package stack_queue;

import java.util.Stack;

public class parentheses {
//코드 전
    // 스택 선언.
    // for으로 s의 길이 만큼 split("")
    // "("면 stack.add
    // ")"면 stack.pop
    // 확인 작업은 peek사용

    //문제점 효율성에서 시간초과가 생김
    // 스플릿 대신 문자열을 직접 순회


//    문자열을 직접 순회(charAt()을 이용)하는 방식이 **split("")**으로 문자열을 나누는 것보다 더 빠릅니다. 그 이유를 단계별로 설명하겠습니다.
//
//            1. split("")의 동작 방식
//    split("")은 문자열을 구분자로 나눠 배열을 생성합니다.
//    내부적으로 정규 표현식을 사용하여 각 문자를 추출하므로 추가 연산과 메모리가 필요합니다.
//    배열 생성이 끝난 후에도, 문자 배열을 순회하는 비용이 추가됩니다.
//    비용:
//
//    문자열을 배열로 변환하는 시간: O(n).
//    배열 순회 시간: O(n).
//    총 시간 복잡도: O(n) + O(n) = O(2n).
//            2. charAt()으로 문자열 직접 순회
//    charAt()은 문자열의 특정 인덱스 위치에서 문자를 가져오는 메서드입니다.
//    문자열은 내부적으로 char 배열 형태로 저장되므로, charAt()은 단순히 해당 배열의 인덱스에 접근합니다.
//    따라서 추가적인 배열 생성이나 메모리 사용 없이 즉시 접근 가능합니다.
//    비용:
//
//    문자열을 한 번 순회하며 charAt() 호출: O(n).
//    총 시간 복잡도: O(n).
    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') {
                stack.add(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()())";
        boolean result = solution(s);
        System.out.println(result);
    }
}
