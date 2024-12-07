package stack_queue.course_schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
//    public static boolean solution(int numCourses, int[][] prerequisites){
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for(int i = 0; i < prerequisites.length; i++){
//            int x = prerequisites[i][0];
//            int y = prerequisites[i][1];
//
//            if(numCourses < x || numCourses < y){
//                return false;
//            }
//
//            if(map.containsKey(y)) {
//                if(map.get(y) == x) {
//                    return false;
//                }
//            }
//            if(x == y) {
//                return false;
//            }
//            map.put(x, y);
//        }
//        return true;
//    }

    public static boolean solution(int numCourses, int[][] prerequisites) {
        //어레이리스트가 아닌 리스트를 쓴 이유:
        // 이유 : 메모리 최적화와 코드 간결성
        // 후속 강의가 없는 경우는 null이기 때문에 메모리를 효율적으로 사용
        // 예시 - ArrayList는 n이 1000인데 10개 과목만 후속강의가 있으면 990개는 빈 리스트를 생성하여 비효율적임

        List<Integer>[] adj = new List[numCourses];

        int[] prerequisiteCount = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for(int[] pair : prerequisites){
            int course = pair[0];
            int pre = pair[1];
            // pre가 있을 때만 어레이리스트로 초기화 시켜서 메모리 효율 증가 시킴
            if(adj[pre] == null){
                adj[pre] = new ArrayList<>();
            }
            adj[pre].add(course);
            prerequisiteCount[course]++;
        }

        for(int i = 0; i < numCourses; i++){
            if(prerequisiteCount[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            if(adj[curr] != null){
                for(int c : adj[curr]) {
                    prerequisiteCount[c]--;
                    if(prerequisiteCount[c] == 0) {
                        queue.offer(c);
                    }
                }
            }
        }
        System.out.println(count);
        return count == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] pre = {{1,0},{0,2},{2,1}};
        boolean result = solution(numCourses, pre);
        System.out.println(result);
    }
}
