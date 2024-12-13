package exam2;

import java.util.Stack;

public class ExcelSheetColumnNumber {
    //시작: 13:09

    // 문제 이해 : 알파벳의 순서를 숫자로 만들기

    // 풀이 방법 : 26^문자의 길이-1
    // 1. 문자의 길이 얻기.
    // 2. 문자에서 숫자로 치환되는 숫자를 알아내기
    // 3. 문자의 길이가 CC일경우 문자 26^(2-1)+2

    // ^은 거듭제곱 x, Math.pow() 사용할 것
    public static int solution(String columnTitle) {
        Stack<Character> stack = new Stack<>();
        int size= 0;
        for(int i = 0; i < columnTitle.length(); i++) {
            stack.push(columnTitle.charAt(i));
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum += (int) (Math.pow(26, size) * (stack.pop() - 'A' + 1));
            System.out.println(sum);
            size++;
        }

        return sum;
    }
    public static void main(String[] args) {
        int result = solution("AB");
        System.out.println(result);
    }
}
