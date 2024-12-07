package failure_ratio;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class FailureRatio {
    public static void main(String[] args) {
            int[] stages = {1, 1, 1, 1};
        int[] result = solution(2, stages);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int N, int[] stages) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> reachedStagePlayer = new HashMap<>();

        for (int stage : stages) {
            map.put(stage, map.getOrDefault(stage, 0) + 1);
        }

        for (int i = 1; i <= N; i++) {
            int reachedCount = 0;
            for (int stage : stages) {
                if (stage >= i) {
                    reachedCount++;
                }
            }
            reachedStagePlayer.put(i, reachedCount);
        }

//        List<int[]> failureRates = new ArrayList<>();
//        for (int i = 1; i <= N; i++) {
//            int failed = map.getOrDefault(i, 0);
//            int reached = reachedStagePlayer.getOrDefault(i, 0);
//            double failureRate = (reached == 0) ? 0.0 : (double) failed / reached;
//
//            failureRates.add(new int[]{i, (int)(failureRate * 1000000)});
//        }
//
//        failureRates.sort((a, b) -> b[1] == a[1] ? a[0] - b[0] : b[1] - a[1]);

        List<Entry<Integer, Double>> failureRates = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int failed = map.getOrDefault(i, 0);
            int reached = reachedStagePlayer.getOrDefault(i, 0);
            double failureRate = (reached == 0) ? 0.0 : (double) failed / reached;

            var entry = new SimpleEntry<>(i, failureRate);

            failureRates.add(entry);
        }

        failureRates.sort((a, b) -> b.getValue().equals(a.getValue()) ? (int) a.getKey() - b.getKey() : (b.getValue() > a.getValue() ? 1 : -1));

        return failureRates.stream().mapToInt(Entry::getKey).toArray();
    }
}
