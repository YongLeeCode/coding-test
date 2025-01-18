package exam3;

// 출처: 프로그래머스
// 문제 제목: 멀리 뛰기
public class JumpCase {
    //시간 초과
//    public static long solution(int n) {
//        long result = dfs(n, 0) % 1234567;
//        return result;
//    }
//
//    private static int dfs(int n, int curr) {
//        if(curr == n) {
//            return 1;
//        }
//        if(curr > n) {
//            return 0;
//        }
//
//        return dfs(n, curr + 1) + dfs(n, curr + 2);
//    }


    //bfs로 만들 수 있나? 고민하다가 막힘
//    public static long solution(int n) {
//        long result = bfs(n) %1234567;
//        return result;
//    }
//
//    private static int bfs(int n) {
//        int count = 0;
//        Queue<Integer> queue = new LinkedList<>();
//
//        while(!queue.isEmpty()) {
//            int curr = 0;
//            for(int i = 0; i < queue.size(); i++) {
//                curr += queue.poll();
//            }
//            if(n > curr + 2) {
//                queue.offer(2);
//            }
//
//            queue.offer(1);
//
//        }
//    }

    //DP 방법
    public static long solution(int n) {
        long[] answer = new long[2000];
        answer[1] = 1;
        answer[2] = 2;

        for(int i = 3; i < answer.length; i++) {
            answer[i] = answer[i - 1] + answer[i - 2] % 1234567;
        }

        return answer[n];
    }

    public static void main(String[] args) {
        int n = 4;
        long result = solution(n);
        System.out.println(result);
    }
}
