package recursiveFunction.count_after_quad_compression;

//부분 문제 나타내기
//상태
//(offsetX, offY, size, arr) = 좌표(offsetX, offsetY)에 시작해 size만큼의 가로, 세로 길이인 정사각형
// arr는 정사각형에 있는 데이터 값

//종료조건 작성하기
// size가 1일 때

//점화식 구현하기 - 부분 문제를 해결하는 로직
// 사이즈^2이 1 혹은 0의 개수와 같다면 압축

import java.util.Arrays;

public class QuadCompression {

    static int[] result = new int[2];

    public static int[] solution(int[][] arr) {
        count(0, 0, arr.length, arr);
        return result;
    }

    public static boolean compress(int offsetY, int offsetX, int size, int[][] arr) {
        //점화식 구현하기 - 부분 문제를 해결하는 로직
        // 모두 다 같은가?
        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {
                if (arr[offsetY][offsetX] != arr[y][x]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void count(int offsetY, int offsetX, int size, int[][] arr) {

        //종료조건 작성하기
        if (compress(offsetY, offsetX, size, arr)) {
            if (arr[offsetY][offsetX] == 1) {
                result[1]++;
            } else if (arr[offsetY][offsetX] == 0) {
                result[0]++;
            }

            return;
        }

        int h = size / 2;

        //부분 문제 나타내기
        //상태
        //(offsetX, offY, size, arr) = 좌표(offsetX, offsetY)에 시작해 size만큼의 가로, 세로 길이인 정사각형
        count(offsetY, offsetX, h, arr);
        count(offsetY, offsetX + h, h, arr);
        count(offsetY + h, offsetX, h, arr);
        count(offsetY + h, offsetX + h, h, arr);

    }

    public static void main(String[] args) {
        //쿼드압축 후 숫자 세기
        int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        int[] result = QuadCompression.solution(arr);
        System.out.println(Arrays.toString(result));
    }
}
