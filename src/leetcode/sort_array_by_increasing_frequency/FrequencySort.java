package leetcode.sort_array_by_increasing_frequency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class FrequencySort {

    public static int[] frequencySort(int[] nums) {
        // 빈도수 계산
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Integer[] numsArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        // 정렬
        Arrays.sort(numsArray, (a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);

            // 빈도수가 다르면 오름차순 정렬
            if (freqA != freqB) {
                return freqA - freqB;
            }
            // 빈도수가 같으면 숫자를 내림차순 정렬
            return b - a;
        });

        // Integer[] -> int[]로 변환
        return Arrays.stream(numsArray).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1,5,1,2,2,4,2,3};
        int[] result = frequencySort(nums);
        System.out.println(Arrays.toString(result));
    }
}
