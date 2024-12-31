package exam3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// 처음 시작할 때 Queue에 브릿지 길이 - 1만큼 0을 넣어주고, 첫번째 트럭을 넣어준다.
public class TruckAcrossBridge {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int currentWeight = 0;
        int time = 0;
        int nextTruck = 0;

        // 초기화: 다리를 0으로 채우기
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (!bridge.isEmpty()) {
            time++;
            // 다리를 건넌 트럭 제거
            currentWeight -= bridge.poll();

            // 다음 트럭이 대기 중이고, 다리에 올라갈 수 있으면 추가
            if (nextTruck < truck_weights.length) {
                if (currentWeight + truck_weights[nextTruck] <= weight) {
                    bridge.offer(truck_weights[nextTruck]);
                    currentWeight += truck_weights[nextTruck];
                    nextTruck++;
                } else {
                    // 올라갈 수 없으면 0 추가 (빈 자리 유지)
                    bridge.offer(0);
                }
            }
        }

        return time;
    }

    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weight = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        int result = solution(bridge_length, weight, truck_weight);
        System.out.println(result);
    }
}



// 무게가 같은 트럭은 실패할 수 밖에 없음 - hashmap에 같은 무게는 하나밖에 못 들어가니까 ㅠ
//        Queue<Integer> queue = new LinkedList<>();
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        int time = 0;
//        int currWeight = 0;
//        int index = 0;
//
//        while(index < truck_weights.length || !queue.isEmpty()) {
//        time++;
//
//        if(!queue.isEmpty() && map.get(queue.peek()) >= bridge_length) {
//        int truck = queue.poll();
//        currWeight -= truck;
//            }
//
//                    if (index < truck_weights.length && currWeight + truck_weights[index] <= weight) {
//        queue.offer(truck_weights[index]);
//                map.put(truck_weights[index], 0);
//        currWeight += truck_weights[index];
//        index++;
//        }
//
//        for(int truck : queue) {
//        map.put(truck, map.get(truck) + 1);
//        }
//
//        }
//
//        return time;