package kakaoCodingTest.engilsh_word_with_string_digit;

import java.util.Map;

public class EnglishWordWithStrDigit {

    public static String solveProblem(String s) {
        String[] characters = s.split("");

        Map<String, Integer> hashNum = Map.of(
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4,
                "five", 5,
                "six", 6,
                "seven", 7,
                "eight", 8,
                "nine", 9,
                "zero", 0
        );

        String jo = "";
        StringBuilder newStrNum = new StringBuilder();
        for (String character : characters) {
            jo += character;

            if (jo.matches("\\d")) {
                newStrNum.append(jo);
                jo = "";
            } else if (hashNum.containsKey(jo)) {
                newStrNum.append(hashNum.get(jo));
                jo = "";
            }
        }

        return newStrNum.toString();
    }

    public static void main(String[] args) {
        // 0~9까지 혹은 zero~nine까지 영문 혹은 숫자로 구성된 String
        // String에 영단어로 숫자를 기입한 것을 숫자로 바꾸기
        String input = "onetwo34one9nine";
        String strNumber = EnglishWordWithStrDigit.solveProblem(input);
        System.out.println(strNumber);
    }

}
