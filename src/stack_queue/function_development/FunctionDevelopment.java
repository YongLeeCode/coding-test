package stack_queue.function_development;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


//while을 사용하여서 똑같은 숫자를 오름차순으로 만든다.
//100이 넘는 친구라면 count++
public class FunctionDevelopment {

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> timeCollector = new LinkedList<>();
        for (int progress : progresses) {
            queue.add(progress);
        }

        ArrayList<Integer> result = new ArrayList<>();
        int time = 1;
        for (int i = 0; i < speeds.length; i++) {
            while (queue.peek() + (time * speeds[i]) < 100) {
                time++;
            }
            queue.poll();
            timeCollector.add(time);
        }

        // 비어있지 않으면 루프 돌아!
        while (!timeCollector.isEmpty()) {
            int currentDeployTime = timeCollector.poll(); // 현재 배포 기준 시간
            int count = 1;

            // 같은 배포 기준 시간에 포함되는 작업 수를 계산
            while (!timeCollector.isEmpty() && timeCollector.peek() <= currentDeployTime) {
                timeCollector.poll();
                count++;
            }

            result.add(count); // 배포 가능한 작업 수 추가
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] result = solution(progresses, speeds);
        System.out.println(Arrays.toString(result));
    }
}
