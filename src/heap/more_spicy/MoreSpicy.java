package heap.more_spicy;

import java.util.PriorityQueue;

//재귀호출
// 스코빌 지수 가장 낮은 2개를 찾는다.
// 결과가 k보다 작으면 리턴

// 좋은 방법이 아닌 이유:
// 우선 시간복잡도가 높아질 가능성이 있음
// 재귀호출할 때마다 새로 배열을 만들어야 함
// 코드 만드는데 생각보다 복잡함

// priorityQueue를 사용한 이유
// 일반적인 Queue, Stack과는 달리 priorityQueue는 데이터가 가장 낮은 숫자가 빠져나온다.

public class MoreSpicy {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int s : scoville) {
            heap.add(s);
        }
        int count = 0;
        while (heap.size() > 1 && heap.peek() < K) {
            int first = heap.poll();
            int second = heap.poll();

            int newScoville = first + second * 2;
            heap.add(newScoville);
            count++;
        }

        return heap.peek() >= K ? count : -1;
    }
    public static void main(String[] args) {
        int[] sco = {1, 2, 3, 9, 10, 12};
        int k = 7;
        int result = solution(sco, k);
        System.out.println(result);
    }
}
