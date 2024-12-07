package hash.same_letters_check;

import java.util.HashMap;

public class SameLettersCheck {
    // before의 hashset을 만든다.
    // 각각의 스플릿한 글자들을 비교한다.

    // 문제점:
    // 중복되는 글자가 있을 수 있을 땐 대처가 안된다.

    // 그럼 hashmap을 만들고
    // for loop을 두 개 만들어서 숫자 비교 및 글자 체크?
    public static int solution(String before, String after) {
        HashMap<String, Integer> map = new HashMap<>();

        String[] beforeLetters = before.split("");
        String[] afterLetters = after.split("");

        for(String letter : beforeLetters){
            map.put(letter, map.getOrDefault(letter, 0) + 1);
        }

        for(String letter : afterLetters) {
            if(!map.containsKey(letter)){
               return 0;
            } else {
                map.put(letter, map.get(letter) - 1);
                if(map.get(letter) < 0){
                    return 0;
                }
            }
        }

        return 1;
    }
    public static void main(String[] args) {
        String before = "allpe";
        String after = "apple";
        int result = solution(before, after);
        System.out.println(result);
    }
}
