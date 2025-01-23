package exam3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class stockPrice {

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Queue<Integer> queue = new LinkedList<>();
        for(int price : prices) {
            queue.offer(price);
        }

        int index = 0;
        while(!queue.isEmpty()) {
            int currentPrice = queue.poll();
            for(int i = (prices.length - queue.size()); i < prices.length; i++) {
                answer[index]++;
                if(currentPrice > prices[i]) {
                    break; //
                }
            }
            index++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] result = solution(prices);
        System.out.println(Arrays.toString(result));
    }
}
