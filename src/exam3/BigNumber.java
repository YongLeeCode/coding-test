package exam3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class BigNumber {
    public static String solution(String number, int k) {
//        ArrayList<Integer> list = new ArrayList<>();
//        int[] sortedArr = new int[number.length()];
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        // 문자에서 숫자 배열로
//        for(int i = 0; i < number.length(); i++) {
//            int num = number.charAt(i) - '0';
//            list.add(num);
//            sortedArr[i] = num;
//        }
//
//        // 숫자 정렬
//        Arrays.sort(sortedArr);
//
//        // 숫자를 정렬했을 때 0 ~ k-1까지 정렬된 배열 숫자를 해시맵에 저장
//        for(int i = 0; i < k; i++) {
//            map.put(sortedArr[i], map.getOrDefault(sortedArr[i], 0) + 1);
//        }
//
//        for(int i = 0; i < list.size(); i++) {
//            System.out.println("have + " + map.containsKey(list.get(i)));
//            System.out.println(list.get(i));
//            if(map.containsKey(list.get(i))) {
//                if(map.get(list.get(i)) > 0) {
//                    map.put(list.get(i), map.get(list.get(i)) - 1);
//                    list.set(i, 0);
//                }
//            }
//
//        }
//
//        String answer = "";
//        for(int i = 0; i < list.size(); i++) {
//            if(list.get(i) != 0) {
//                answer += list.get(i);
//            }
//        }
//
//        return answer;

        StringBuilder answer = new StringBuilder();
        int length = number.length() - k; // 최종 문자열의 길이
        Stack<Character> stack = new Stack<>();

        for (char digit : number.toCharArray()) {
            // 스택에서 숫자를 제거하여 큰 수를 만든다
            while (!stack.isEmpty() && k > 0 && stack.peek() < digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // 스택에서 필요한 만큼 숫자를 가져와 결과를 생성
        for (int i = 0; i < length; i++) {
            answer.append(stack.get(i));
        }

        return answer.toString();
    }
    public static void main(String[] args) {
        String number = "1231234";
        int k = 3;

        String result =solution(number, k);
        System.out.println(result);
    }
}
