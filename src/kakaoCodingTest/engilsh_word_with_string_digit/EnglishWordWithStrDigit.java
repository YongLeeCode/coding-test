package kakaoCodingTest;

import java.util.Map;

public class EnglishWordWithStrDigit {

    public static void solveProblem(String s) {
        String[] characters = s.split("");

        //map
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
        String newStrNum = "";
        for (String character : characters) {
            jo += character;

            //match method
            if (jo.matches("\\d")){
                newStrNum += jo;
                jo = "";
            } else if (hashNum.containsKey(jo)) {
                newStrNum += hashNum.get(jo);
                jo = "";
            }
        }
        System.out.println(newStrNum);


    }

}
