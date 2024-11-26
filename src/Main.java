import kakaoCodingTest.EnglishWordWithStrDigit;

public class Main {

    public static void main(String[] args) {

        // 0~9까지 혹은 zero~nine까지 영문 혹은 숫자로 구성된 String
        // String에 영단어로 숫자를 기입한 것을 숫자로 바꾸기
        String input = "onetwo34one9nine";
        EnglishWordWithStrDigit.solution(input);
    }
}