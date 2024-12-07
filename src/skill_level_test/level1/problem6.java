package skill_level_test.level1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class problem6 {
    // 개인정보 유효기간
// https://school.programmers.co.kr/learn/courses/30/lessons/150370
    public static int[] solution(String today, String[] terms, String[] privacies) {
        String[] strDate = today.split("\\.");
        int[] date = new int[3];
        for(int i = 0; i < strDate.length; i++) {
            date[i] = Integer.parseInt(strDate[i]);
        }
        LocalDate currentDate = LocalDate.of(date[0], date[1], date[2]);

//        ["A 6", "B 12", "C 3"]
        HashMap<String, Integer> map = new HashMap<>();
        for(String term : terms){
            String[] t = term.split(" ");
            map.put(t[0], Integer.valueOf(t[1]));
        }

        String result = "";
        for(int j = 0; j < privacies.length; j++){
            String[] p = privacies[j].split(" ");
            String[] strPrivacyDate = p[0].split("\\.");
            int[] pDate = new int[3];
            for(int i = 0; i < strDate.length; i++) {
                pDate[i] = Integer.parseInt(strPrivacyDate[i]);
            }
            LocalDate privacyDate = LocalDate.of(pDate[0], pDate[1], pDate[2]);

            if(privacyDate.plusMonths(map.get(p[1])).isBefore(currentDate)) {
                result += ( j+1 );
            }
        }
        String[] slicedStrResult = result.split("");
        int[] realResult = new int[slicedStrResult.length];
        for(int i = 0; i < slicedStrResult.length; i++) {
            realResult[i] = Integer.parseInt(slicedStrResult[i]);
        }
        return realResult;
    }

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        int[] result = solution(today, terms, privacies);
        System.out.println(Arrays.toString(result));
    }
}
