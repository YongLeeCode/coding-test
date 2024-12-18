package exam3;

import java.util.LinkedList;
import java.util.Queue;

public class JumpAndTeleport {
    // n : 도착지점
    // jump : 한 칸 이동 , 건전지 1 사용
    // tel : 현재 칸 * 2로 이동, 건전지 0 사용
    public static int solution(int n) {
//        Queue<Integer> queue = new LinkedList<>();
//
//        final int jump = 1;
//        int curr = 0;
//        int battery = 0;
//        int teleport = curr * 2;
//
//        queue.offer(jump);
//        battery++;
//
//        while(!queue.isEmpty()){
//            if(curr > n) break;
//            if(curr == n) break;
//            curr += queue.poll();
//            System.out.println(curr);
//            queue.offer(teleport);
//            queue.offer(jump);
//            battery++;
//        }
//        return battery;

        int battery = 0;

        while(n > 0){
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                battery++;
            }
        }
        return battery;
    }

    public static void main(String[] args) {
        int result = solution(5);
        System.out.println(result);
    }
}
