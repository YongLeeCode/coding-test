package exam3;

import java.util.Stack;

public class DeliveryBox {
    public static int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int nextItem;

        int firstContainer = 1;

        for (int i = 0; i < order.length; i++) {
            nextItem = order[result];

            while (firstContainer <= nextItem) {
                stack.push(firstContainer);
                firstContainer++;
            }

            if (!stack.isEmpty() && stack.peek() == nextItem) {
                stack.pop();
                result++;
            } else {
                break;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[ ] order = {4,3,6,1,2,5};
        int result = solution(order);
        System.out.println(result);
    }
}