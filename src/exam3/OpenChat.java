package exam3;

// 출처 : 프로그래머스
// 문제 제목: 오픈채팅방

import java.util.Arrays;
import java.util.HashMap;

public class OpenChat {

    public static String[] solution(String[] record) {
        HashMap<String, String> id = new HashMap<>();
        HashMap<String, String> move = new HashMap<>();

        // 채팅방 이동
        move.put("Enter", "들어왔습니다.");
        move.put("Leave", "나갔습니다.");

        int entrance = 0;
        for (String s : record) {
            String[] rec = s.split(" ");
            if (rec[0].equals("Enter") || rec[0].equals("Leave")) {
                entrance++;
            }

            if (rec[0].equals("Enter") || rec[0].equals("Change")) {
                id.put(rec[1], rec[2]);
            }
        }

        String[] answer = new String[entrance];
        int index = 0;
        for (String s : record) {
            String[] rec = s.split(" ");
            if(!rec[0].equals("Change")) {
                answer[index] = String.format("%s님이 %s", id.get(rec[1]), move.get(rec[0]));
                index++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] record = {
            "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        };

        String[] result = solution(record);
        System.out.println(Arrays.toString(result));
    }
}
