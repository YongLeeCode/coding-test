package stack_queue.bfs_letters;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BfsLetters {

    public static void solution(String str) {
        HashMap<String, String[]> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        String start = "A";
        String[] arrStr = str.split("\n");

        for (int i = 0; i < arrStr.length; i++) {
            String[] a = arrStr[i].split(" ");
            String[] children = {a[1], a[2]};
            map.put(a[0], children);
        }

        StringBuilder result = new StringBuilder();
        queue.offer(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            // 스타트 "A"를 시작으로 map의 key로 사용

            result.append(current);
            String[] children = map.get(current);
            // 큐에 저장
            if (children != null) {
                queue.offer(children[0]);
                queue.offer(children[1]);
            }

            System.out.println(current);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        String str = "A B C\n"
                + "B D E\n"
                + "C F G\n"
                + "D H I\n"
                + "E J K\n"
                + "F L M\n"
                + "G N O";
        solution(str);
//        System.out.println(str);
    }
}
