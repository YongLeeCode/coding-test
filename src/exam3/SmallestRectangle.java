package exam3;

// 출처: 프로그래머스
// 문제 제목: 최소 직사각형

// 코딩 작성 전 풀이 방법
// 1. 가로와 세로 길이를 위한 변수를 0으로 선언한다.
// 2. 반복문을 만든다.
// 3. 반복문이 돌면서 생기는 가로와 세로 숫자가 변수에 있던 숫자보다 높다면 바꿔준다.
// 4. 리턴한다.

// 풀이의 문제점
// - 특정 상황에는 세로 혹은 가로를 바꿔야 한다.

// 가로가 세로보다 항상 길게 만들었다.
// 문제는 풀렸지만 코드적으로 봤을 때 상당히 길다.

// 다른 사람들의 풀이 방법
// Math.max()와 Math.min()을 사용하여 깔끔하게 만든 것을 볼 수 있었다.

// Math.max()를 구현 했을 때
// public static int max(int a, int b) {
//     return (a >= b) ? a : b;
// }
// 그러므로 시간복잡도는 O(1)

public class SmallestRectangle {

    public static int solution(int[][] sizes) {
        int row = 0, col = 0;

//            //내가 푼 문제:
//        for (int[] size : sizes) {
//
//            //가로가 항상 길게 만든다.
//            int r = 0;
//            int c = 0;
//
//            if(size[0] < size[1]) {
//                r = size[1];
//                c = size[0];
//            } else {
//                r = size[0];
//                c = size[1];
//            }
//
//            if (row < r) {
//                row = r;
//            }
//            if (col < c) {
//                col = c;
//            }
//        }

        // 다른 사람들의 풀이를 본 후 푼 방법
        for (int[] size : sizes) {
            row = Math.max(row, Math.max(size[0], size[1]));
            col = Math.max(col, Math.min(size[0], size[1]));
        }

        return row * col;
    }

    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int result = solution(sizes);
        System.out.println(result);
    }
}
