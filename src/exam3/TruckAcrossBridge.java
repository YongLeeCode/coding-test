package exam3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// 완전히 오른 트럭만 무게 측정
//
public class TruckAcrossBridge {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int currWeight = 0;
        int index = 1;

        while(index < truck_weights.length || !queue.isEmpty()) {
            time++;

            if(!queue.isEmpty() && map.get(queue.peek()) >= bridge_length) {
                int truck = queue.poll();
                currWeight -= truck;
            }

            if (index < truck_weights.length && currWeight + truck_weights[index] <= weight) {
                queue.offer(truck_weights[index]);
                map.put(truck_weights[index], 0);
                currWeight += truck_weights[index];
                index++;
            }

            for(int truck : queue) {
                map.put(truck, map.get(truck) + 1);
            }

        }

        return time;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weight = {7, 4, 5, 6};

        int result = solution(bridge_length, weight, truck_weight);
        System.out.println(result);
    }
}
