package exam3;

import java.util.Arrays;
import java.util.HashMap;

// 앞 숫자의 가장 큰 숫자로 정렬
// 같은 앞자리 숫자인데 뒷 자리가 크기가 다를 때
//
public class BiggestNumber {
    public static String solution(int[] numbers) {
        StringBuilder result = new StringBuilder();
        HashMap<String, int[]> map = new HashMap<>();
        String[] order = new String[numbers.length];
        int[] res = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            String frontNumber = String.valueOf(numbers[i]).substring(0, 1);
            if(map.containsKey(frontNumber)) {
               // 정렬 후에 맵에 집어넣기
            } else {
                // 처음 맵에 집어 넣을 경우 그냥 집어 넣기
                map.put(frontNumber, new int[]{numbers[i]});
            }

            order[i] = frontNumber;
        }
        int[] intOrder = Arrays.stream(order).mapToInt(value -> Integer.parseInt(value)).sorted().toArray();
        for(int i = numbers.length-1; i >= 0; i--) {
            int[] sortedNumbers = map.get(String.valueOf(intOrder[i]));

            for(int sortNum : sortedNumbers) {
                result.append(String.valueOf(sortNum));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        String result = solution(numbers);
        System.out.println(result);
    }
}
