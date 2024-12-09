package skill_level_test.level1;

import java.util.ArrayList;
import java.util.Collections;

//문자열 내림차순으로 배치하기
public class Problem12 {
    public static void solution(String s) {
        ArrayList<Integer> sNum = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.println(c + " " + (int) c);
            sNum.add((int) c);
        }

        Collections.sort(sNum);

        for(int i = sNum.size()-1; i >= 0; i--) {
            result.append((char) ((int)sNum.get(i)));
        }
    }
    public static void main(String[] args) {
        String s ="Zbcdefg";
        solution(s);
        System.out.println();
    }
}

//문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
//s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.