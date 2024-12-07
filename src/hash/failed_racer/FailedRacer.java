package hash.failed_racer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class FailedRacer {
    // hashmap을 사용
    // value가 1이상 인 key들을 새로운 어레이에 넣는다.

    // 문제 풀다가 문제점: 1이상인 map을 어떻게 가져와야하지?

    // 해결 방법: Entry를 사용하기

    // 더 좋은 방법 : completion으로 -1했을 때 key의 값이 0이면 아예 map에서 지워버리기
    // 그럴 경우 keySet() 메서드로 남아있는 key들을 불러 올 수 있다
    public static String[] solution(String[] participants, String[] completions) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String p : participants) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for(String c : completions) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        List<String> failedPeople = new ArrayList<>();
        for(Entry e : map.entrySet()){
            int count = (int)e.getValue();
            while(count >= 1) {
                failedPeople.add(String.valueOf(e.getKey()));
                count--;
            }
        }

//        System.out.println(map.keySet());
        return failedPeople.toArray(new String[0]);
    }

    public static void main(String[] args){
        String[] racers = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String[] result = solution(racers, completion);
        System.out.println(Arrays.toString(result));
    }
}
