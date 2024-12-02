package dimentionalArray.tirangleSnail;

import java.util.Arrays;
import java.util.HashMap;

public class TriangleSnail {
    private static final int n = 5;

    //내가 푼 방법
    public static void solveProblem() {
        // n은 y축의 최대 숫자다.
        // y축 아래로 이동 [0,0], [0,1], [0,2]
        // x축 오른쪽으로 이동 [1,2], [2,2],
        // y축 위로 이동 [1,1]
        // 채워진 숫자를 차례대로 1차원 배열에 옮겨서 반환

        // int[][]를 만든다. 이때 헷갈릴 수 있는데 [y][x] 순이다.
        // 몇 칸 움직였는지 카운트
        int count = 0;
        // 최초 현재 위치 (0,0) 설정
        HashMap<Integer, String> trianglePointers = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++) {
                String pointer = i + ", " + j;
                count++;
                trianglePointers.put(count, pointer);
            }
        }

        //linkedhashmap과 함께 이렇게 해도 되지만
//        for(Entry<Integer, String> entry : trianglePointers.entrySet()){
//            System.out.printf("%d번째 시도: (%s)\n", entry.getKey(), entry.getValue());
//        }

        // 숫자 순으로 key 값을 넣어서 그걸 사용해도 될 듯 하다.
        for(int i = 1; i <= count; i++) {
            System.out.printf("%d번째 시도: (%s)\n", i, trianglePointers.get(i));
        }
    }

    // 책에 알려준 방법
    // 좌표가 순서대로 상 - 하 - 좌 - 우 움직일 때
    // 이때 d는 방향을 나타내준다
//    private static final int[] dx = {0, 0, -1, 1};
//    private static final int[] dy = {1, -1, 0, 0};

    //그리고 삼각 달팽이 문제에 사용되는 dx와 dy
    // 아래(0, 1), 오른쪽(1, 0), 왼쪽위(-1, -1)
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public static void solution() {
        int[][] triangle = new int[n][n];
        int v = 1, x = 0, y = 0, d = 0;

        while (true) {
            //무한 루프 안에서 다음과 같이 triangle에 숫자를 채워 줌
            triangle[y][x] = v++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
                d = (d + 1) % 3;
                nx = x + dx[d];
                ny = y + dy[d];
                if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break;
            }

            x = nx;
            y = ny;
        }

        int[] result = new int[v-1];
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }
        for (int j : result) {
            System.out.println(j);
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        solveProblem();
        solution();
    }
}


