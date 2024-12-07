package stack_queue.stock_prices;

import java.util.Stack;

public class StockPrices {
    // 어떻게 만들어야하지??????
    // for loop의 index를 이용해볼까?
    // 비교를 하는거야.
    public static int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[prices.length];
        stack.add(prices[0]);

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] >= stack.peek()) {
                stack.add(prices[i]);
            } else {
                int under = stack.pop();
            }
            System.out.println(stack.peek());
        }
        return result;
    }
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        int[] result = solution(prices);
        System.out.println(result);
    }
}
